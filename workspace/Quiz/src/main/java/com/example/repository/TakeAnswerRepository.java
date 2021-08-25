/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.TakeAnswer;

@Repository
@Transactional
public interface TakeAnswerRepository extends JpaRepository<TakeAnswer, Long> {

	List<TakeAnswer> findByTakeId(Long id);
	
	List<TakeAnswer> findByQuestionId(Long id);
	
	List<TakeAnswer> findByAnswerId(Long id);
	
}
