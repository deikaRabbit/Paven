package com.paven.exception;

public class NotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5893607462016363588L;

	public NotFoundException() {
	}

	public NotFoundException(String msg) {
		super(msg);
	}

}
