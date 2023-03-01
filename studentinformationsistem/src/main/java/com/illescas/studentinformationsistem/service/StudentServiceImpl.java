package com.illescas.studentinformationsistem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.illescas.studentinformationsistem.model.Student;
import com.illescas.studentinformationsistem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findByStudentNumber(Long studentNumber) {
		return studentRepository.findByStudentNumber(studentNumber);
	}

	@Override
	public Student findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}

	@Override
	public List<Student> findAllByOrderByGpa() {
		return studentRepository.findAllByOrderByGpa();
	}
	
	@Override
	public void saveOrUpdateStudent(Student student) { 
		studentRepository.save(student);
	}
	
	@Override
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}

}