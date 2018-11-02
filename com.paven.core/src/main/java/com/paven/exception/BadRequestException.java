package com.paven.exception;

public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7375285796029201167L;

	public BadRequestException() {
	}

	public BadRequestException(String msg) {
		super(msg);
	}

}
