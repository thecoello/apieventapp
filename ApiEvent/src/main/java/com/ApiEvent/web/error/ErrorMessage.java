package com.ApiEvent.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)

public class ErrorMessage extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErrorMessage(String message) {
		super(message);
	}
}
