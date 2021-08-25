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

import com.example.entity.Answer;
import com.example.repository.AnswerRepository;
import com.example.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public Answer create(Answer answer) {
		return answerRepository.save(answer);
	}

	@Override
	public List<Answer> findAll() {
		return answerRepository.findAll();
	}

	@Override
	public List<Answer> findByQuizId(Long id) {
		return answerRepository.findByQuizId(id);
	}

	@Override
	public List<Answer> findByQuestionId(Long id) {
		return answerRepository.findByQuestionId(id);
	}

	@Override
	public Answer update(Answer answer) {
		return answerRepository.save(answer);
	}

}
