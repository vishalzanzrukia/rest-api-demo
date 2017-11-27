package com.demo.rest.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.dto.ApiDataResponse;

@RestController
public class ApiController extends AbstractBaseController {
	
	private static final Logger LOG = LogManager.getLogger();

	@RequestMapping(path = "success", method = RequestMethod.GET)
	public ResponseEntity<ApiDataResponse<String>> getUserStats(@RequestParam final long userId) {
		final ApiDataResponse<String> response = ApiDataResponse.buildSuccessResponse("This is success response",
				"Data has been retrieved successfully.");
		LOG.debug("User stats success response : {}", response);
		return response200(response);
	}
}
