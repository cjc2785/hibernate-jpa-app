package com.gcit.training.hibernatejpaapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class  ControllerExceptionHandler {
	
	@ExceptionHandler(ResourceException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleResourceNotFound() { 
		return "Resource not found";
	}
}