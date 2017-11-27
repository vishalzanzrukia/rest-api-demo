package com.demo.rest.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The {@code ApiResponse} is the basic class for all api response.
 * 
 * @author VishalZanzrukia
 * @version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 4839165731137661784L;

	private boolean success;
	private int status;
	private long timestamp;
	private String message = "No message available";

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Builds the success response.
	 *
	 * @param <T>
	 *            the generic type
	 * @param message
	 *            the message
	 * @return the  api response
	 */
	public static ApiResponse buildSuccessResponse(final String message) {
		final ApiResponse response = new ApiResponse();
		response.setSuccess(true);
		if (message != null) {
			response.setMessage(message);
		}
		response.setTimestamp(new Date().getTime());
		return response;
	}

	/**
	 * Builds the failure response.
	 *
	 * @param <T>
	 *            the generic type
	 * @param errorMsg
	 *            the error msg
	 * @param status
	 *            the status
	 * @return the api response
	 */
	public static ApiResponse buildFailureResponse(final String errorMsg, final HttpStatus status) {
		final ApiResponse response = new ApiResponse();
		response.setSuccess(false);
		response.setMessage(errorMsg);
		response.setStatus(status.value());
		response.setTimestamp(new Date().getTime());
		return response;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
