package com.ing.exception;

public class AccountNumberException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public AccountNumberException(String message) {
		
		super(message);
	}
}
