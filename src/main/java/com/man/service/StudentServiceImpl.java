package com.man.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.man.dto.StudentDto;
import com.man.repo.StudentRepo;

import nonapi.io.github.classgraph.json.JSONUtils;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repo;

	@Override
	@Transactional
	public List<StudentDto> getAllStudent() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public StudentDto addStudent(StudentDto s) {
		return repo.save(s);
	}

	@Override
	@Transactional
	public StudentDto findbyId(int id) {
		if(!ObjectUtils.isEmpty(id)) {
		return repo.getById(id);
		}
		else {
			return null;
		}
	}

	@Override
	@Transactional
	public StudentDto update(StudentDto dto) {
		Optional<StudentDto> isExist = repo.findById(dto.getId());
		if (!ObjectUtils.isEmpty(isExist)) {
			dto.setEmail(dto.getEmail());
			dto.setFirstName(dto.getFirstName());
			dto.setLastName(dto.getLastName());
			repo.save(dto);
		} else {
			System.out.println("Plzz Enter Valid id");
		}
		return dto;
	}

	
	@Override
	@Transactional
	public StudentDto fildByEmail(String email) {
		StudentDto dto = new StudentDto();
		
		if (!ObjectUtils.isEmpty(email)) {

			dto = repo.findByEmail(email);
			return dto;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public StudentDto deleteById(int id) {
		StudentDto dto=new StudentDto();
		repo.deleteById(id);
		return dto;
	}

}
