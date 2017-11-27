package com.demo.rest.error;

import org.springframework.http.HttpStatus;

/**
 * The Class AppInternalException.
 * 
 * @author VishalZanzrukia
 */
public class AppInternalServerException extends AppRuntimeException {

	private static final long serialVersionUID = -1496575719554696207L;

	public AppInternalServerException(String msg) {
		super(msg);
	}

	public AppInternalServerException(String msg, Throwable e) {
		super(msg, e);
	}

	@Override
	public HttpStatus getStatus() {
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
}
