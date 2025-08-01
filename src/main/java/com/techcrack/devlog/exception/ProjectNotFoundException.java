package com.techcrack.devlog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -8170803689229837180L;

	public ProjectNotFoundException(String message) {
		super(message);
	}
}
