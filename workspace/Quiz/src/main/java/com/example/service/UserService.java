/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 23, 2021
 * @ version 1.0
 */

package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService {
	
	List<User> findAll();

	User findByUsernameAndPassword(String username, String password);
	
	User create(User user);
	
}
