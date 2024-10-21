package com.seva.mailsender.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class MailSenderException extends RuntimeException {
	
	private static final long serialVersionUID = -6440189420172543071L;
	private final HttpStatus httpStatus;
	
	public MailSenderException(HttpStatus httpStatus, String message) { 
		super(message);
		this.httpStatus = httpStatus;
	}		

}
