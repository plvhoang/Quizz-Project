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
@Table(name = "answer", indexes = {
		@Index(name = "uqidx_answser_quizId", columnList = "quizId ASC"),
		@Index(name = "uqidx_answser_questionId", columnList = "questionId ASC") })
public class Answer {

	@Id
	@Column(name = "id", length = 20)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "quizId", nullable = false, foreignKey = @ForeignKey(name = "fk_answer_quiz_quizId"))
	private Quiz quiz;

	@ManyToOne
	@JoinColumn(name = "questionId", nullable = false, foreignKey = @ForeignKey(name = "fk_answer_question_questionId"))
	private Question question;

	@Column(name = "correct", columnDefinition = "tinyint(1)", nullable = false)
	@ColumnDefault(value = "0")
	private boolean correct;

	@Column(name = "content", columnDefinition = "text")
	@ColumnDefault(value = "null")
	private String content;

	@OneToMany(mappedBy = "answer")
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<TakeAnswer> getListOfTakeAnswers() {
		return listOfTakeAnswers;
	}

	public void setListOfTakeAnswers(List<TakeAnswer> listOfTakeAnswers) {
		this.listOfTakeAnswers = listOfTakeAnswers;
	}

}
