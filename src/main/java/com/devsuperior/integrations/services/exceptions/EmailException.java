package com.devsuperior.integrations.services.exceptions;

import java.io.Serializable;

public class EmailException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public EmailException(String msg) {
		super(msg);
	}
}
