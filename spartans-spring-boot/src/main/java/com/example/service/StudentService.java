package com.example.service;

import java.util.List;

import com.example.model.Student;


public interface StudentService {

	Student getById(Integer id);

	List<Student> findAll();

	 

}
