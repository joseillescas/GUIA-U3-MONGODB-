package com.illescas.studentinformationsistem.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.illescas.studentinformationsistem.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	Student findByStudentNumber(Long studentNumber);

	Student findByEmail(String email);

	List<Student> findAllByOrderByGpa();

}