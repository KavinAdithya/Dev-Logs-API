package com.techcrack.devlog.exception;

public class DeveloperNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DeveloperNotFoundException(String message) {
		super(message);
	}
}
