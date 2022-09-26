package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptionhandler.StudentException;
import com.masai.model.Student;
import com.masai.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao sDao;

	@Override
	public Student saveStudent(Student student) {

		Student savedStudent = sDao.save(student);

//		this savedStudent will have Auto generated ID
		return savedStudent;

	}

	@Override
	public Student getStudentByRoll(Integer roll) {

		Optional<Student> opts = sDao.findById(roll);

//		if(opts.isPresent()) return opts.get();
//		else throw new StudentException("Student does not exist..");

		return opts.orElseThrow(() -> new StudentException("Student does not exist with roll:." + roll));
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = sDao.findAll();
		if (students.size() > 0) {
			return students;
		} else {
			throw new StudentException("No students data");
		}

	}

	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {

		Student s = sDao.findById(roll).orElseThrow(()-> new StudentException("Student does not exist.."));
		
		sDao.delete(s);
		
		return s;
	}

	@Override
	public Student updateStudent(Student student) throws StudentException {
		
		
		Optional<Student> opts = sDao.findById(student.getRoll()); 
		
		if(opts.isPresent()) {
			
			Student exixstingStudent = opts.get();
			
			return sDao.save(student);			
		}
		else {
			throw new StudentException("Student does not exists..");
		}
	}

	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException {
		
		Optional<Student> opts = sDao.findById(roll);
		
		if(opts.isPresent()) {
			
			Student exixstingStudent = opts.get();
			
			exixstingStudent.setMarks(exixstingStudent.getMarks()+graceMarks);
			
			return sDao.save(exixstingStudent);
			
		}else {
			throw new StudentException("Student does not exists with roll" + roll);
		}
		
	}

}
