package com.techcrack.devlog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LogNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 8909491239098172297L;

	public LogNotFoundException(String message) {
		super(message);
	}
}
