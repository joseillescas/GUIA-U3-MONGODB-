package com.illescas.studentinformationsistem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.illescas.studentinformationsistem.model.Student;
import com.illescas.studentinformationsistem.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public List<Student> getAllStudents() {
		return studentService.findAll();
	}

	@GetMapping("/{studentNumber}")
	public Student getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber) {
		return studentService.findByStudentNumber(studentNumber);
	}

	@GetMapping("/email/{email}")
	public Student findByEmail(@PathVariable("email") String email) {
		return studentService.findByEmail(email);
	}

	@GetMapping("/gpa")
	public List<Student> findAllByOrderByGpa() {
		return studentService.findAllByOrderByGpa();
	}

	@PostMapping("/")
	public ResponseEntity<String> saveOrUpdateStudent(@RequestBody Student student) {
		studentService.saveOrUpdateStudent(student);
		return ResponseEntity.ok("Estudiante agregado con exito");
	}

	@DeleteMapping("/{studentNumber}")
	public void deleteStudent(@PathVariable Long studentNumber) {
		studentService.deleteStudent(studentService.findByStudentNumber(studentNumber).getId());
	}
}