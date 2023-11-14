package com.UserBusiness.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ProfileNotFoundHandler {
	
	@ExceptionHandler(value = {ProfileNotFound.class})
	public ResponseEntity<Object> responseHandler(ProfileNotFound profileNotFound){
		
		ProfileNotFoundResponse profileNotFoundResponse = new ProfileNotFoundResponse(profileNotFound.getMessage(),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(profileNotFoundResponse,HttpStatus.NOT_FOUND);
	}
	

}
