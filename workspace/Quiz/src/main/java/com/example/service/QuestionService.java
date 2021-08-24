/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.service;

import java.util.List;

import com.example.entity.Question;

public interface QuestionService {
	
	Question create(Question question);
	
	List<Question> findAll();
	
	List<Question> findByQuizId(Long id);
	
	Question update(Question question);

}
