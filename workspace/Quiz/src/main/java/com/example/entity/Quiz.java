/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 24, 2021
 * @ version 1.0
 */

package com.example.entity;

import java.time.LocalDateTime;
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
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quiz", indexes = {
		@Index(name = "uqidx_hostId", columnList = "hostId ASC", unique = true) })
public class Quiz {

	@Id
	@Column(name = "id", length = 20)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "hostId", nullable = false, foreignKey = @ForeignKey(name = "fk_hostId"))
	private User user;

	@Column(name = "title", length = 75, nullable = false)
	private String title;

	@Column(name = "score", columnDefinition = "smallint(6)", nullable = false)
	@ColumnDefault(value = "0")
	private int score;

	@Column(name = "startsAt")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ColumnDefault(value = "null")
	private LocalDateTime startsAt;

	@Column(name = "endsAt")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ColumnDefault(value = "null")
	private LocalDateTime endsAt;

	@Column(name = "content", columnDefinition = "text")
	@ColumnDefault(value = "null")
	private String content;
	
	@OneToMany(mappedBy = "quiz")
	@JsonIgnore
	private List<Question> listOfQuenstions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public LocalDateTime getStartsAt() {
		return startsAt;
	}

	public void setStartsAt(LocalDateTime startsAt) {
		this.startsAt = startsAt;
	}

	public LocalDateTime getEndsAt() {
		return endsAt;
	}

	public void setEndsAt(LocalDateTime endsAt) {
		this.endsAt = endsAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Question> getListOfQuenstions() {
		return listOfQuenstions;
	}

	public void setListOfQuenstions(List<Question> listOfQuenstions) {
		this.listOfQuenstions = listOfQuenstions;
	}

}
