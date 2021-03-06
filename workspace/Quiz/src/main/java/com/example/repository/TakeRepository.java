/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Take;

@Repository
@Transactional
public interface TakeRepository extends JpaRepository<Take, Long> {

	List<Take> findByUserId(Long id);
	
	List<Take> findByQuizId(Long id);
	
	Take findByUserIdAndQuizId(Long userId, Long quizId);
	
	@Query(value ="select * from take where quiz_id = :id order by score DESC", nativeQuery = true)
	List<Take> findByQuizIdAndSort(@Param("id") Long id);
}
