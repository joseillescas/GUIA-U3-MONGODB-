package com.illescas.studentinformationsistem.service;

import java.util.List;
import com.illescas.studentinformationsistem.model.Student;

public interface StudentService {

	List<Student> findAll();

	Student findByStudentNumber(Long studentNumber);

	Student findByEmail(String email);

	List<Student> findAllByOrderByGpa();

	void saveOrUpdateStudent(Student student);

	void deleteStudent(String id);

}