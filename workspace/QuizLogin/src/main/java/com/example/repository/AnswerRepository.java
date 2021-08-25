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

import com.example.entity.Answer;

@Repository
@Transactional
public interface AnswerRepository extends JpaRepository<Answer, Long> {
	
	List<Answer> findByQuizId(Long id);
	
	List<Answer> findByQuestionId(Long id);

}
