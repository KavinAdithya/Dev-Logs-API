package com.techcrack.devlog.exception;

public class ProjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -8170803689229837180L;

	public ProjectNotFoundException(String message) {
		super(message);
	}
}
