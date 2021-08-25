/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.service;

import java.util.List;

import com.example.entity.TakeAnswer;

public interface TakeAnswerService {

	TakeAnswer create(TakeAnswer takeAnswer);

	List<TakeAnswer> findAll();

	List<TakeAnswer> findByTakeId(Long id);

	List<TakeAnswer> findByQuestionId(Long id);

	List<TakeAnswer> findByAnswerId(Long id);

	TakeAnswer update(TakeAnswer takeAnswer);

}
