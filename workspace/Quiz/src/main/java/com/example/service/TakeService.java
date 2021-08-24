/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.service;

import java.util.List;

import com.example.entity.Take;

public interface TakeService {

	Take create(Take take);
	
	List<Take> findAll();

	List<Take> findByUserId(Long id);

	List<Take> findByQuizId(Long id);

	Take update(Take take);

}
