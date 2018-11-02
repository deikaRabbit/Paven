package com.paven.exception;

public class ExceptionResponse {

	private Integer errorCode;
	private String exception;

	public ExceptionResponse() {
	}

	public ExceptionResponse(Integer errorcode) {
		this.errorCode = errorcode;
	}

	public ExceptionResponse(Integer errorCode, String msg) {
		this.errorCode = errorCode;
		this.exception = msg;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}
}
