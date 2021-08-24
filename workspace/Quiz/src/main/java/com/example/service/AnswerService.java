/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.service;

import java.util.List;

import com.example.entity.Answer;

public interface AnswerService {

	Answer create(Answer answer);

	List<Answer> findAll();

	List<Answer> findByQuizId(Long id);

	List<Answer> findByQuestionId(Long id);

	Answer update(Answer answer);

}
