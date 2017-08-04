package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	List<User> findAllUsers();
	User findById(Integer id);
	User findByName(String name);
	boolean isUserExist(User user);
	void updateUser(User user);
	 
}
