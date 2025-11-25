package com.Myapps.airBnbApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Myapps.airBnbApp.advice.ApiResponse;

@RestController
public class HealthCheckAwsController {
	
	@GetMapping("/")
	public ApiResponse healthCheckAwsController() {
	    return new ApiResponse();
	}

}
