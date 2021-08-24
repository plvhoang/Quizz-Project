/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Quiz;
import com.example.service.QuizService;

@RestController
public class QuizTestController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/api/quiz/create")
	public Quiz create(@RequestBody Quiz quiz) {
		return quizService.create(quiz);
	}
	
	@GetMapping("/api/quiz/all")
	public List<Quiz> findAll() {
		return quizService.findAll();
	}
	
	@GetMapping("/api/quiz/user/{id}")
	public List<Quiz> findByHostId(@PathVariable(name = "id") String id) {
		return quizService.findByUserId(Long.parseLong(id));
	}
	
	@PostMapping("/api/quiz/update")
	public Quiz update(@RequestBody Quiz quiz) {
		return quizService.update(quiz);
	}

}
