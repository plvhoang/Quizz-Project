package com.example.dao;

import org.springframework.security.crypto.password.PasswordEncoder;

public class DefaultEncoder implements PasswordEncoder{
	// This Encoder doesn't not encode anything. It's made for the app to run.
	@Override
	public String encode(CharSequence rawPassword) {
		return (String) rawPassword;
		
	}
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encodedPassword.equals((String) rawPassword);
	}
}
