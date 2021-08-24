/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 23, 2021
 * @ version 1.0
 */

package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserTestController {

	@Autowired
	private UserService userService;

	@PostMapping("/api/user/create")
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	@GetMapping("/api/user/all")
	public List<User> findAll() {
		return userService.findAll();
	}

	@PostMapping("/api/user/get")
	public User findByUsernameAndPassword(@RequestParam String username,
			@RequestParam String password) {
		return userService.findByUsernameAndPassword(username, password);
	}

	@PostMapping("/api/user/update")
	public User update(@RequestBody User user) {
		return userService.update(user);
	}

}
