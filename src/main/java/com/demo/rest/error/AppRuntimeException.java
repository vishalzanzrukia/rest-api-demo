package com.demo.rest.error;

import org.springframework.http.HttpStatus;

import com.demo.rest.util.AppUtil;

/**
 * The Class AppBadRequestException.
 * 
 * @author VishalZanzrukia
 */
public abstract class AppRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -4533388950514870138L;

	abstract public HttpStatus getStatus();

	public AppRuntimeException(String msg) {
		super(msg);
	}

	public AppRuntimeException(String msg, Throwable e) {
		super(msg, e);
	}

	@Override
	public String getMessage() {
		return AppUtil.getCombinedErrorMessage(super.getMessage(), this.getCause());
	}
}
