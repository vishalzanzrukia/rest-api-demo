package com.demo.rest.error;

import org.springframework.http.HttpStatus;

/**
 * The Class AppUnauthorizedException.
 * 
 * @author VishalZanzrukia
 */
public class AppUnauthorizedException extends AppRuntimeException {

	private static final long serialVersionUID = -1496575719554696207L;

	public AppUnauthorizedException(String msg) {
		super(msg);
	}

	public AppUnauthorizedException(String msg, Throwable e) {
		super(msg, e);
	}

	@Override
	public HttpStatus getStatus() {
		return HttpStatus.UNAUTHORIZED;
	}
}
