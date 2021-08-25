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

import com.example.entity.Take;
import com.example.service.TakeService;

@RestController
public class TakeTestController {
	
	@Autowired
	private TakeService takeService;
	
	@PostMapping("/api/take/create")
	public Take create(@RequestBody Take take) {
		return takeService.create(take);
	}
	
	@GetMapping("/api/take/all")
	public List<Take> findAll() {
		return takeService.findAll();
	}
	
	@GetMapping("/api/take/user/{id}")
	public List<Take> findByUserId(@PathVariable(name = "id") String id) {
		return takeService.findByUserId(Long.parseLong(id));
	}
	
	@GetMapping("/api/take/quiz/{id}")
	public List<Take> findByQuizId(@PathVariable(name = "id") String id) {
		return takeService.findByQuizId(Long.parseLong(id));
	}
	
	@PostMapping("/api/take/update")
	public Take update(@RequestBody Take take) {
		return takeService.update(take);
	}

}
