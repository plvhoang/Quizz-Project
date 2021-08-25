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

import com.example.entity.TakeAnswer;
import com.example.service.TakeAnswerService;

@RestController
public class TakeAnswerTestController {

	@Autowired
	private TakeAnswerService takeAnswerService;

	@PostMapping("/api/take-answer/create")
	public TakeAnswer create(@RequestBody TakeAnswer takeAnswer) {
		return takeAnswerService.create(takeAnswer);
	}

	@GetMapping("/api/take-answer/all")
	public List<TakeAnswer> findAll() {
		return takeAnswerService.findAll();
	}

	@GetMapping("/api/take-answer/take/{id}")
	public List<TakeAnswer> findByTakeId(@PathVariable(name = "id") String id) {
		return takeAnswerService.findByTakeId(Long.parseLong(id));
	}

	@GetMapping("/api/take-answer/question/{id}")
	public List<TakeAnswer> findByQuestionId(
			@PathVariable(name = "id") String id) {
		return takeAnswerService.findByQuestionId(Long.parseLong(id));
	}

	@GetMapping("/api/take-answer/answer/{id}")
	public List<TakeAnswer> findByAnswerId(
			@PathVariable(name = "id") String id) {
		return takeAnswerService.findByAnswerId(Long.parseLong(id));
	}

	@PostMapping("/api/take-answer/update")
	public TakeAnswer update(@RequestBody TakeAnswer takeAnswer) {
		return takeAnswerService.create(takeAnswer);
	}

}
