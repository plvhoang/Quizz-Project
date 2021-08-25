/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "take_answer", indexes = {
		@Index(name = "uqidx_takeAnswer_takeId", columnList = "takeId ASC"),
		@Index(name = "uqidx_takeAnswer_questionId", columnList = "questionId ASC"),
		@Index(name = "uqidx_takeAnswer_answerId", columnList = "answerId ASC")
})
public class TakeAnswer {

	@Id
	@Column(name = "id", length = 20)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "takeId", nullable = false, foreignKey = @ForeignKey(name = "fk_takeAnswer_take_takeId"))
	private Take take;

	@ManyToOne
	@JoinColumn(name = "questionId", nullable = false, foreignKey = @ForeignKey(name = "fk_takeAnswer_question_questionId"))
	private Question question;
	
	@ManyToOne
	@JoinColumn(name = "answerId", nullable = false, foreignKey = @ForeignKey(name = "fk_takeAnswer_answer_answerId"))
	private Answer answer;
	
	@Column(name = "content", columnDefinition = "text")
	@ColumnDefault(value = "null")
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Take getTake() {
		return take;
	}

	public void setTake(Take take) {
		this.take = take;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
