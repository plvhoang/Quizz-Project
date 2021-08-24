/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Question;
import com.example.service.QuestionService;

@RestController
public class QuestionTestController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/api/question/create")
	public Question create(@RequestBody Question question) {
		return questionService.create(question);
	}
	
	@GetMapping("api/question/all")
	public List<Question> findAll() {
		return questionService.findAll();
	}
	
	@GetMapping("api/question/quiz/{id}")
	public List<Question> findByQuizId(@PathVariable(name = "id") String id) {
		return questionService.findByQuizId(Long.parseLong(id));
	}
	
	@PostMapping("/api/question/update")
	public Question update(@RequestBody Question question) {
		return questionService.update(question);
	}

}
