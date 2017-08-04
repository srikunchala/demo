package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import com.example.repository.UserRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	
	@Override
	public Student getById(Integer id) {
		 
		return studentRepository.findById(id);
	}
	
	@Override
	 public List<Student> findAll() {
		 System.out.println("in side fina lll  ");
		return studentRepository.findAll();
	}
	
	
}
