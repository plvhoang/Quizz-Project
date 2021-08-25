/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "question", indexes = {
		@Index(name = "uqidx_question_quizId", columnList = "quizId ASC") })
public class Question {

	@Id
	@Column(name = "id", length = 20)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "quizId", nullable = false, foreignKey = @ForeignKey(name = "fk_question_quiz_quizId"))
	private Quiz quiz;

	@Column(name = "type", length = 50, nullable = false)
	private String type;

	@Column(name = "score", columnDefinition = "smallint(6)", nullable = false)
	@ColumnDefault(value = "0")
	private int score;

	@Column(name = "content", columnDefinition = "text")
	@ColumnDefault(value = "null")
	private String content;
	
	@OneToMany(mappedBy = "question")
	@JsonIgnore
	private List<Answer> listOfAnswers;
	
	@OneToMany(mappedBy = "question")
	@JsonIgnore
	private List<TakeAnswer> listOfTakeAnswers;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Answer> getListOfAnswers() {
		return listOfAnswers;
	}

	public void setListOfAnswers(List<Answer> listOfAnswers) {
		this.listOfAnswers = listOfAnswers;
	}

	public List<TakeAnswer> getListOfTakeAnswers() {
		return listOfTakeAnswers;
	}

	public void setListOfTakeAnswers(List<TakeAnswer> listOfTakeAnswers) {
		this.listOfTakeAnswers = listOfTakeAnswers;
	}

}
