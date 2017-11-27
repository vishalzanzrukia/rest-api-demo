package com.demo.rest.dto;

import java.util.Date;

import org.springframework.http.HttpStatus;

/**
 * The Class ApiDataResponse.
 *
 * @param <T>
 *            the generic type
 * @author VishalZanzrukia
 */
public class ApiDataResponse<T> extends ApiResponse {

	private static final long serialVersionUID = 5923295650970575231L;

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Builds the success response.
	 *
	 * @param <T>
	 *            the generic type
	 * @param value
	 *            the value
	 * @param message
	 *            the message
	 * @return the  api response
	 */
	public static <T> ApiDataResponse<T> buildSuccessResponse(final T value, final String message) {
		final ApiDataResponse<T> response = new ApiDataResponse<>();
		response.setSuccess(true);
		response.setData(value);
		if (message != null) {
			response.setMessage(message);
		}
		response.setTimestamp(new Date().getTime());
		return response;
	}

	/**
	 * Builds the success response.
	 *
	 * @param <T>
	 *            the generic type
	 * @param value
	 *            the value
	 * @return the  api data response
	 */
	/*public static <T> ApiDataResponse<T> buildSuccessResponse(final T value) {
		return buildSuccessResponse(value, HttpStatus.OK.getReasonPhrase());
	}*/
}
