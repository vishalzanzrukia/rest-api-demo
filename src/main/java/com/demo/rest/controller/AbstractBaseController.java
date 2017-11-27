package com.demo.rest.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.rest.dto.ApiDataResponse;
import com.demo.rest.dto.ApiResponse;
import com.demo.rest.error.AppRuntimeException;
import com.demo.rest.util.AppUtil;

/**
 * The {@code AbstractBaseController} is base class for all controller, it will
 * provide basic helper methods needed for actual controller implementations
 * 
 * @author VishalZanzrukia
 * @see {@link ApiController}
 * @version 1.0
 */
@RequestMapping("/v1/api/")
public abstract class AbstractBaseController extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LogManager.getLogger();
	
	/**
	 * Handle exception.
	 *
	 * @param ex
	 *            the ex
	 * @return the response entity
	 */
	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<ApiResponse> handleException(final RuntimeException ex) {
		LOG.error(ex.getMessage(), ex);
		final HttpStatus status;
		final String errorMsg;
		if (ex instanceof AppRuntimeException) {
			status = ((AppRuntimeException) ex).getStatus();
			errorMsg = ex.getMessage();
		} else {
			errorMsg = "An unexpected error occurred while trying to handle your request, the error : "
					+ ex.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		final ApiResponse response = ApiResponse.buildFailureResponse(errorMsg, status);
		LOG.error("The failure response : {}", response);
		return new ResponseEntity<ApiResponse>(response, status);
	}

	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return handle("Make sure the request url is right.", ex, status);
	}

	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handle("Make sure request body is not empty.", ex, status);
	}

	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handle("Make sure all request parameter are present.", ex, status);
	}

	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return handle("Make sure all request parameter values are proper.", ex, status);
	}
	
	/**
	 * Handle.
	 *
	 * @param message
	 *            the message
	 * @param ex
	 *            the ex
	 * @param status
	 *            the status
	 * @return the response entity
	 */
	private ResponseEntity<Object> handle(String message, Exception ex, HttpStatus status) {
		final ApiResponse response = ApiResponse.buildFailureResponse(AppUtil.getCombinedErrorMessage(message, ex),
				status);
		LOG.error("The failure response : {}", response);
		return new ResponseEntity<Object>(response, status);
	}

	/**
	 * Response200.
	 *
	 * @param response
	 *            the response
	 * @return the response entity
	 */
	protected ResponseEntity<ApiResponse> response200(final ApiResponse response) {
		LOG.debug("Response 200 : {}", response);
		response.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

	/**
	 * Response200.
	 *
	 * @param <T>
	 *            the generic type
	 * @param response
	 *            the response
	 * @return the response entity
	 */
	protected <T> ResponseEntity<ApiDataResponse<T>> response200(final ApiDataResponse<T> response) {
		LOG.debug("Response 200 : {}", response);
		response.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ApiDataResponse<T>>(response, HttpStatus.OK);
	}

	/**
	 * Response201.
	 *
	 * @param <T>
	 *            the generic type
	 * @param response
	 *            the response
	 * @return the response entity
	 */
	protected <T> ResponseEntity<ApiDataResponse<T>> response201(final ApiDataResponse<T> response) {
		LOG.debug("Response 201 : {}", response);
		response.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ApiDataResponse<T>>(response, HttpStatus.CREATED);
	}
}
