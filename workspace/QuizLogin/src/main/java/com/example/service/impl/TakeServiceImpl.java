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

import com.example.entity.Take;
import com.example.repository.TakeRepository;
import com.example.service.TakeService;

@Service
public class TakeServiceImpl implements TakeService {
	
	@Autowired
	private TakeRepository takeRepository;

	@Override
	public Take create(Take take) {
		return takeRepository.save(take);
	}

	@Override
	public List<Take> findAll() {
		return takeRepository.findAll();
	}

	@Override
	public List<Take> findByUserId(Long id) {
		return takeRepository.findByUserId(id);
	}

	@Override
	public List<Take> findByQuizId(Long id) {
		return takeRepository.findByQuizId(id);
	}

	@Override
	public Take update(Take take) {
		return takeRepository.save(take);
	}

}
