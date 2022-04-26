package com.man.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.man.dto.StudentDto;

@Repository
public interface StudentRepo extends JpaRepository<StudentDto, Integer>  {

	@Query(value = "SELECT * FROM  gitstudent u WHERE u.email = :email ", 
			  nativeQuery = true)
	public StudentDto findByEmail(@Param ("email") String  email);
	
}
  