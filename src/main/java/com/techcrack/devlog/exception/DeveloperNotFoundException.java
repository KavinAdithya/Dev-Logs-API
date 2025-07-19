package com.techcrack.devlog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DeveloperNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DeveloperNotFoundException(String message) {
		super(message);
	}
}
