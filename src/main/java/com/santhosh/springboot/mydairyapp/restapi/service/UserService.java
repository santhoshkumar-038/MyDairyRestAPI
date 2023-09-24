package com.santhosh.springboot.mydairyapp.restapi.service;

import java.util.List;

import com.santhosh.springboot.mydairyapp.restapi.entity.User;

public interface UserService {
	public User saveUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
	public User getUserById(int id);
	public List<User> getUsers();
	public User findByUsername(String username);
}
