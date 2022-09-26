package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptionhandler.NoEmployeeFoundException;
import com.masai.model.Employee;
import com.masai.repository.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO empDao;
	
	@Override
	public List<Employee> getAllemployees() throws NoEmployeeFoundException{
		
		List<Employee> empList = empDao.findAll();
		
		if(empList == null) throw new NoEmployeeFoundException("No employee data found...");
		
		return empList;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		
		return empDao.save(emp);
		
	}

	@Override
	public Employee updateEmployee(Integer empId, Employee emp) {

		Optional<Employee> e_emp = empDao.findById(empId); 
		
		if(!e_emp.isPresent()) throw new NoEmployeeFoundException("No employee data found with Id: " + empId);
		
		Employee e = e_emp.get();
		e.setName(emp.getName());
		e.setSalary(emp.getSalary());
		e.setCity(emp.getCity());
		e.setState(emp.getState());
		e.setPincode(emp.getPincode());
		
		return empDao.save(e);
		
	}

	@Override
	public String deleteEmployee(Integer empId) {
		
		Optional<Employee> e_emp = empDao.findById(empId); 
		
		if(!e_emp.isPresent()) throw new NoEmployeeFoundException("No employee data found with Id: " + empId);
		
		
		empDao.delete(e_emp.get());
		return "Employee deleted succefully with Id :" + empId;
		
	}

	@Override
	public List<Employee> getEmployeesByDept(String deptName) {
		
		List<Employee> empList = empDao.findByDeptName(deptName);
		
		if(empList == null) throw new NoEmployeeFoundException("No employee data found for department: " + deptName);
			
		return empList;
	}

}
