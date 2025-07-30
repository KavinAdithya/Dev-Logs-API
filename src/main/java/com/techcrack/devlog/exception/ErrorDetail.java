package com.techcrack.devlog.exception;

import java.time.LocalDateTime;

public class ErrorDetail {
	private String message;
	
	private LocalDateTime dateTime;
	
	public ErrorDetail(String message, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.dateTime = dateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
