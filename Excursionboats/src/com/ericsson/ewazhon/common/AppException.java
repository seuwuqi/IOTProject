package com.ericsson.ewazhon.common;

public class AppException extends Exception {
	private String error;
	private Throwable cause;

	public AppException(String message, Throwable t) {
		error = message;
		cause = t;
	}

	public String getMessage() {
		return error;
	}

	public String toString() {
		return error;
	}

	public Throwable getCause() {
		return this.cause;
	}

}
