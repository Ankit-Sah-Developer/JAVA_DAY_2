package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptionhandler.StudentException;
import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService sService;

	@PostMapping("/student")
	public Student saveStudentHandler(@RequestBody Student student) {

		return sService.saveStudent(student);

	}

	@GetMapping("/students/{roll}")
	public Student getStudentHandler(@PathVariable Integer roll){

		return sService.getStudentByRoll(roll);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentHandler() {

		List<Student> stds = sService.getAllStudents();

		return new ResponseEntity<List<Student>>(stds, HttpStatus.OK);
	}

	@DeleteMapping("/students/{roll}")
	public Student deleteStudentHandler(@PathVariable Integer roll) {

		return sService.deleteStudentByRoll(roll);
	}
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student s) {

		Student student = sService.updateStudent(s);

		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentMarks(@PathVariable("roll") Integer roll, Integer graceMarks)  {

		Student student = sService.updateStudentMarks(roll, graceMarks);

		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}
