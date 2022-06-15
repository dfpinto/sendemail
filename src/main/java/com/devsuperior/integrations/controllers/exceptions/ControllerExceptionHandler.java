package com.devsuperior.integrations.controllers.exceptions;

import java.io.ObjectInputFilter.Status;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.integrations.services.exceptions.EmailException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(EmailException.class)
	public ResponseEntity<StandardError> email(EmailException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Email error");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
