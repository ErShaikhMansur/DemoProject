package com.man.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.man.Page.StudentPage;
import com.man.Page.StudentSearchCriteria;
import com.man.dto.StudentDto;

public interface StudentService {
	
	List<StudentDto> getAllStudent();

	public StudentDto addStudent(StudentDto s);

	public StudentDto findbyId(int id);

	public StudentDto update(StudentDto dto);
	
	public StudentDto deleteById(int id);
	
	public StudentDto fildByEmail(String email);
	
	public List<StudentDto> findAllBySorting(String field);
	
	public Page<StudentDto> findPaginationandFilter(StudentPage studentPage, StudentSearchCriteria studentSearchCriteria);
}
