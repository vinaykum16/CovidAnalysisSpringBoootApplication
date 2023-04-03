package com.covid_analysis.exception;

public class InvalidStateCodeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidStateCodeException(String message) {
		super(message);
	}

}
