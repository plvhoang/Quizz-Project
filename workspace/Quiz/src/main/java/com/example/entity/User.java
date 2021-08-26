/*
 * @ Copyright 2021 Fresher Academy. All Rights Reserved.
 * @ author HOANG DUY
 * @ date Aug 23, 2021
 * @ version 1.0
 */

package com.example.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user", indexes = {
		@Index(name = "uqidx_username", columnList = "username asc",unique = true) })
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", length = 50, nullable = false)
	private String username;

	@Column(name = "password", length = 32, nullable = false)
	private String password;

	@Column(name = "email", length = 50)
	@ColumnDefault(value = "null")
	private String email;

	@Column(name = "host", columnDefinition = "tinyint(1)", nullable = false)
	@ColumnDefault(value = "0")
	private boolean host;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Quiz> listOfQuizes;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Take> listOfTakes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isHost() {
		return host;
	}

	public void setHost(boolean host) {
		this.host = host;
	}

	public List<Quiz> getListOfQuizes() {
		return listOfQuizes;
	}

	public void setListOfQuizes(List<Quiz> listOfQuizes) {
		this.listOfQuizes = listOfQuizes;
	}

	public List<Take> getListOfTakes() {
		return listOfTakes;
	}

	public void setListOfTakes(List<Take> listOfTakes) {
		this.listOfTakes = listOfTakes;
	}

}
