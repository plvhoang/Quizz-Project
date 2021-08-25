/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.service;

import java.util.List;
import com.example.entity.Quiz;

public interface QuizService {
	
	Quiz create(Quiz quiz);
	
	List<Quiz> findAll();
	
	List<Quiz> findByUserId(Long id);
	
	Quiz update(Quiz quiz);

}
