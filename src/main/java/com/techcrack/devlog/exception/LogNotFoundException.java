package com.techcrack.devlog.exception;

public class LogNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 8909491239098172297L;

	public LogNotFoundException(String message) {
		super(message);
	}
}
