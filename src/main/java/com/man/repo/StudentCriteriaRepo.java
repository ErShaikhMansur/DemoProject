package com.man.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.man.Page.StudentPage;
import com.man.Page.StudentSearchCriteria;
import com.man.dto.StudentDto;

@Repository
public class StudentCriteriaRepo {
private final EntityManager entitymanager;
private  final CriteriaBuilder criteriaBuilder;

public StudentCriteriaRepo(EntityManager entitymanager) {

	this.entitymanager = entitymanager;
	this.criteriaBuilder =entitymanager.getCriteriaBuilder();
}

public Page<StudentDto> findAllByFilter(StudentPage studentPage,
		StudentSearchCriteria studentSearchCriteria){
	CriteriaQuery<StudentDto> criteriaQuery=criteriaBuilder.createQuery(StudentDto.class);
	Root<StudentDto> studentRoot=criteriaQuery.from(StudentDto.class);
	Predicate predicate=getPredicate(studentSearchCriteria,studentRoot);
	criteriaQuery.where(predicate);
	setOrder(studentPage, criteriaQuery, studentRoot);
	TypedQuery<StudentDto> query=entitymanager.createQuery(criteriaQuery);
	query.setFirstResult(studentPage.getPageNo()*studentPage.getPageSize());
	query.setMaxResults(studentPage.getPageSize());
	Pageable pageable=getPageable(studentPage);
	long studentCount=getStudentCount(predicate);
	return new PageImpl<>(query.getResultList(), pageable, studentCount);
}

private Predicate getPredicate(StudentSearchCriteria studentSearchCriteria,
	            Root<StudentDto> studentRoot) {
	List<Predicate> predicates=new ArrayList<>();
	if(Objects.nonNull(studentSearchCriteria.getFirstname())) {
		predicates.add(
				criteriaBuilder.like(studentRoot.get("firstName"),
						"%"+studentSearchCriteria.getFirstname()));
	}
	if(Objects.nonNull(studentSearchCriteria.getLastName())) {
		predicates.add(
				criteriaBuilder.like(studentRoot.get("lastName"),
						"%"+studentSearchCriteria.getLastName()));
	}
	
	return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
}

public void setOrder(StudentPage studentPage,CriteriaQuery<StudentDto> criteriaQuery
		,Root<StudentDto> root) {
	if(studentPage.getSortDirection().equals(Sort.Direction.ASC)) {
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get(studentPage.getSortBy())));
	}
	else {
		criteriaQuery.orderBy(criteriaBuilder.desc(root.get(studentPage.getSortBy())));
	}
}

public Pageable getPageable(StudentPage studentPage) {
	Sort sort=Sort.by(studentPage.getSortDirection(),studentPage.getSortBy());
	return PageRequest.of(studentPage.getPageNo(),studentPage.getPageSize(),sort);
}

public long getStudentCount(Predicate predicate) {
	CriteriaQuery<Long> criteriaQuery=criteriaBuilder.createQuery(Long.class);
	Root<StudentDto> root=criteriaQuery.from(StudentDto.class);
	criteriaQuery.select(criteriaBuilder.count(root)).where(predicate);
	return entitymanager.createQuery(criteriaQuery).getSingleResult();
	
}
}
