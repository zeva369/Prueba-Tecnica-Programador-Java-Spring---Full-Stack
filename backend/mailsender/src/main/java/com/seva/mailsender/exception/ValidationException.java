package com.seva.mailsender.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

public class ValidationException extends MailSenderException{
    private final BindingResult result;
	
	public ValidationException(BindingResult result) {
		super(HttpStatus.BAD_REQUEST, null);
		this.result = result;
	}
	
	public BindingResult getResult() {
		return result;
	}	
}
