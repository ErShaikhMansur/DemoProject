package com.man.service;

import java.util.List;
import java.util.Optional;

import com.man.dto.StudentDto;

public interface StudentService {
	
	List<StudentDto> getAllStudent();

	public StudentDto addStudent(StudentDto s);

	public StudentDto findbyId(int id);

	public StudentDto update(StudentDto dto);
	
	public StudentDto deleteById(int id);
	
	public StudentDto fildByEmail(String email);
}
