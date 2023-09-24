package com.santhosh.springboot.mydairyapp.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santhosh.springboot.mydairyapp.restapi.entity.User;
import com.santhosh.springboot.mydairyapp.restapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public List<User> findAllUsers() {
		List<User> users = userService.getUsers();
		return users;
	}
	
	@GetMapping("/{id}")
	public User findUser(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		return user;
	}
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return user1;
	}

	@PutMapping("/")
	public User updateUser(@RequestBody User user) {
		User user1 = userService.updateUser(user);
		return user1;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		User user = userService.getUserById(id);
		userService.deleteUser(user);
	}
}
