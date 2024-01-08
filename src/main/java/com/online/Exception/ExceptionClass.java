package com.online.Exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice()

public class ExceptionClass {


	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String exceptionHandlerGeneric()
	{
		return "error/404";
	}
	

	@ExceptionHandler(value=NullPointerException.class)
	public String exception() {
		return "error/500";
		
	}
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String exceptionHAndlerGeneric() {
		return "error/500";
		
	}
	
	
}
