package com.rest.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
