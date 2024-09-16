package com.icici.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class KycNotFoundException extends RuntimeException {
	
	public KycNotFoundException(String message) {
		super(message);
	}

}
