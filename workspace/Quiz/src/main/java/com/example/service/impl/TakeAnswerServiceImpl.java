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

import com.example.entity.TakeAnswer;
import com.example.repository.TakeAnswerRepository;
import com.example.service.TakeAnswerService;

@Service
public class TakeAnswerServiceImpl implements TakeAnswerService {
	
	@Autowired
	private TakeAnswerRepository takeAnswerRepository;

	@Override
	public TakeAnswer create(TakeAnswer takeAnswer) {
		return takeAnswerRepository.save(takeAnswer);
	}

	@Override
	public List<TakeAnswer> findAll() {
		return takeAnswerRepository.findAll();
	}

	@Override
	public List<TakeAnswer> findByTakeId(Long id) {
		return takeAnswerRepository.findByTakeId(id);
	}

	@Override
	public List<TakeAnswer> findByQuestionId(Long id) {
		return takeAnswerRepository.findByQuestionId(id);
	}

	@Override
	public List<TakeAnswer> findByAnswerId(Long id) {
		return takeAnswerRepository.findByAnswerId(id);
	}

	@Override
	public TakeAnswer update(TakeAnswer takeAnswer) {
		return takeAnswerRepository.save(takeAnswer);
	}

}
