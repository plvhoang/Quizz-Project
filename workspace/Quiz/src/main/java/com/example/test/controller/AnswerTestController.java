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

import com.example.entity.Answer;
import com.example.service.AnswerService;

@RestController
public class AnswerTestController {
	
	@Autowired
	private AnswerService answerService;
	
	@PostMapping("/api/answer/create")
	public Answer create(@RequestBody Answer answer) {
		return answerService.create(answer);
	}
	
	@GetMapping("api/answer/all")
	public List<Answer> findAll() {
		return answerService.findAll();
	}
	
	@GetMapping("api/answer/quiz/{id}")
	public List<Answer> findByQuizId(@PathVariable(name = "id") String id) {
		return answerService.findByQuizId(Long.parseLong(id));
	}
	
	@GetMapping("api/answer/question/{id}")
	public List<Answer> findByQuestionId(@PathVariable(name = "id") String id) {
		return answerService.findByQuestionId(Long.parseLong(id));
	}
	
	@PostMapping("/api/answer/update")
	public Answer update(@RequestBody Answer answer) {
		return answerService.update(answer);
	}

}
