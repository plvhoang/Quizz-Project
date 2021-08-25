/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.repository.UserRepository;
import com.example.entity.NewUser;
import com.example.entity.User;

@Controller
public class UserController {
	@Autowired
    private UserRepository appUserRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
    	model.addAttribute("newUser", new NewUser());
    	model.addAttribute("loginFocused", true);
    	model.addAttribute("registerSuccess", false);
        return "login";
    }
    
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(Model model, @ModelAttribute("newUser") NewUser newUser) {
    	String errorMsg = null;
    	
    	try {
    		User newUserDB = new User();
    		String emailRegex = "^(.+)@(.+)$";
    		Pattern pattern = Pattern.compile(emailRegex);
    		Matcher matcher = pattern.matcher(newUser.getEmail());
    		
    		if (!newUser.getPassword().equals(newUser.getRepeatPassword()))
    			errorMsg = "Repeat password does not match!";
    		else if (!matcher.matches())
    			errorMsg = "Invalid email format!";
    		
    		if (errorMsg == null) {
    			newUserDB.setUsername(newUser.getUsername());
        		newUserDB.setPassword(passwordEncoder.encode(newUser.getPassword()));
        		newUserDB.setEmail(newUser.getEmail());
        		appUserRepo.save(newUserDB);
    		}   		
    		
    	} catch (Exception e) {	
    	}
    	
    	if (errorMsg != null) {
    		model.addAttribute("loginFocused", false);
    		model.addAttribute("registerSuccess", false);
    		model.addAttribute("registerMsg", errorMsg);
    	}
    		
    	else {
    		model.addAttribute("registerSuccess", true);
    		model.addAttribute("loginFocused", true);
    	}
    		
    	
    	return "login";
    }
}