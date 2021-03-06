package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Student;
import com.example.model.User;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {
	 
	 Student findById(Integer id);
	 
	 
}
