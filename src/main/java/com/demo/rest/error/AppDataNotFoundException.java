package com.demo.rest.error;

import org.springframework.http.HttpStatus;

/**
 * The Class AppInternalException.
 * 
 * @author VishalZanzrukia
 */
public class AppDataNotFoundException extends AppRuntimeException {

	private static final long serialVersionUID = -1496575719554696207L;

	public AppDataNotFoundException(String msg) {
		super(msg);
	}

	public AppDataNotFoundException(String msg, Throwable e) {
		super(msg, e);
	}

	@Override
	public HttpStatus getStatus() {
		return HttpStatus.NOT_FOUND;
	}
}
