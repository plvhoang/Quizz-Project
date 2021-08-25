/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Quiz;
import com.example.repository.QuizRepository;
import com.example.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz create(Quiz quiz) {
		return quizRepository.save(quiz);
	}
	
	@Override
	public List<Quiz> findAll() {
		return quizRepository.findAll();
	}

	@Override
	public List<Quiz> findByUserId(Long id) {
		return quizRepository.findByUserId(id);
	}

	@Override
	public Quiz update(Quiz quiz) {
		return quizRepository.save(quiz);
	}

}
