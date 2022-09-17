package com.masai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptionhandler.InvalidRollNumberException;
import com.masai.model.Student;

@RestController
public class StudentController {
	
	@GetMapping("/student/{roll}")
	public Student get(@PathVariable Integer roll){
		
		if(roll < 100)
			throw new InvalidRollNumberException("Roll no should be greater than 100..");
		
		
		
		return new Student(roll, "Ramesh", 300);
		
	}
	

	
	

//	@GetMapping("/hello")
//	public ResponseEntity<String> StringsayHello() {
//		
//		HttpHeaders hh=new HttpHeaders();
//		hh.add("jwt", "sdnjnwjk3kj412321231sdf");
//		hh.add("user", "admin");
//		hh.add("hello", "abc");
//		
//		ResponseEntity<String> re = new ResponseEntity<>("Welcome Baba",HttpStatus.ACCEPTED);
//		
//		return re;
//	}
//
//	@GetMapping("/student/{roll}")
//	public Student getStudentHandler(@PathVariable("roll") Integer roll) {
//
//		Student student = new Student(roll, "Ram", 966);
//
//		return student;
//	}
//
//	@GetMapping("/students")
//	public List<Student> getStudentHandler() {
//
//		return Arrays.asList(
//
//				new Student(10, "Ram", 966), new Student(20, "Ramesh", 566), new Student(30, "Ravi", 776),
//				new Student(40, "Rakesh", 886)
//
//		);
//	}
//
//	@GetMapping("/getStudent")
//	public Student getStudentHandler2(@RequestParam Integer roll,
//									  @RequestParam String name,
//									  @RequestParam Integer marks) {
//
//		Student student = new Student(roll, name, marks);
//
//		return student;
//	}
//	
//	
//	@PostMapping(value="/students",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String saveStudentsDetails(@RequestBody Student student) {
//		
//		
//		return "Student stored, "+student;
//	}
//	
//	@PutMapping(value = "/students/{roll}")
//	public Student updateStudentHandler(@RequestBody Student student, @PathVariable Integer roll) {
//		
//		student.setMarks(student.getMarks()+50);
//		
//		return student;
//		
//	}
}
