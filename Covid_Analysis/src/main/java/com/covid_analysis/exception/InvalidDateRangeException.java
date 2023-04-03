package com.covid_analysis.exception;

public class InvalidDateRangeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidDateRangeException(String message) {
		super(message);
	}


}
