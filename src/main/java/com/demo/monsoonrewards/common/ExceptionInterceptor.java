package com.demo.monsoonrewards.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<CustomException> handleAllExceptions(CustomException exception) {
		return new ResponseEntity<CustomException>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
