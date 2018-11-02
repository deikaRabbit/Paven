package com.paven.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebExceptionAdvice {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ExceptionResponse> BadRequestHandler(BadRequestException ex) {
		ExceptionResponse response = new ExceptionResponse(HttpStatus.BAD_REQUEST.value());
		response.setException(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponse> NotFoundHandler(NotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND.value());
		response.setException(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
}
