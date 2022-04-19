package com.jld.keycloackapi.application.controllers.exceptions;

public class BlankRequestHeaderException extends RuntimeException {

	public BlankRequestHeaderException(String message) {
		super(message);
	}

}
