package com.UserBusiness.ExceptionHandlers;

import org.springframework.http.HttpStatus;

public class ProfileNotFoundResponse {
	
	private final String message;
	private final HttpStatus status;
	

	public ProfileNotFoundResponse(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public HttpStatus getStatus() {
		return status;
	}
	
	
	
	
	
	

}
