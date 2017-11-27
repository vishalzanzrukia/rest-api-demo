package com.demo.rest.error;

import org.springframework.http.HttpStatus;

/**
 * The Class AppBadRequestException.
 * 
 * @author VishalZanzrukia
 */
public class AppBadRequestException extends AppRuntimeException {

	private static final long serialVersionUID = -1496575719554696207L;

	public AppBadRequestException(String msg) {
		super(msg);
	}

	public AppBadRequestException(String msg, Throwable e) {
		super(msg, e);
	}

	@Override
	public HttpStatus getStatus() {
		return HttpStatus.BAD_REQUEST;
	}
}
