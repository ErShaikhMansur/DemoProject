package com.man.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.man.dto.StudentDto;
import com.man.service.StudentService;
import com.man.utility.JsonUtil;

import nonapi.io.github.classgraph.json.JSONUtils;

@RestController
public class StudentCtl {
 
	
	@Autowired
	private StudentService service;
	
	@PostMapping(value="/save")
	public ResponseEntity<StudentDto> save(@RequestBody StudentDto dto){
		return new ResponseEntity<StudentDto>(service.addStudent(dto),HttpStatus.OK);
	}
	  
	@GetMapping(value="/list")
	public ResponseEntity<StudentDto> getAllStudent(){
		return new ResponseEntity(service.getAllStudent(),HttpStatus.OK);
	}

	@GetMapping(value="/student/{id}")
	public ResponseEntity<StudentDto> getById(@PathVariable ("id") int id){
		
		return new ResponseEntity(service.findbyId(id),HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto dto){
		return new ResponseEntity(service.update(dto),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<StudentDto> deleteStudent(@PathVariable int id){
		return new ResponseEntity(service.deleteById(id),HttpStatus.OK);
	}
	
	@GetMapping(value="/email/{email}")
	public ResponseEntity<StudentDto> findByEmail(@PathVariable("email") String email){
		return new ResponseEntity(service.fildByEmail(email),HttpStatus.OK);
	}
}
	
