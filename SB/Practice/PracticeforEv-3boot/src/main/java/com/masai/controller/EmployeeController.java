package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;
import com.masai.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getAllEmployeesDetails() {

		return new ResponseEntity<List<Employee>>(empService.getAllemployees(), HttpStatus.OK);

	}

	@GetMapping("/listbydept/{deptName}")
	public ResponseEntity<List<Employee>> getAllEmployeesDetailsByDeptName(@PathVariable("deptName") String deptName) {

		return new ResponseEntity<List<Employee>>(empService.getEmployeesByDept(deptName), HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp) {

		return new ResponseEntity<Employee>(empService.addEmployee(emp), HttpStatus.CREATED);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Integer empId,
			@Valid @RequestBody Employee emp) {

		return new ResponseEntity<Employee>(empService.updateEmployee(empId, emp), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> updateEmployee(@PathVariable("empId") Integer empId) {

		return new ResponseEntity<String>(empService.deleteEmployee(empId), HttpStatus.CREATED);
	}
}
