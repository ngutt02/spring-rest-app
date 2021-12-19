package com.pack.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class MyAdvice {

	
	@ExceptionHandler(BookDoesNotExistException.class)
	public List exceptionHandler1(BookDoesNotExistException e)

	{
		List list=new ArrayList();
		list.add("  A book with the given id doesnot exist with id in database");
		
		return list;
	}
	@ExceptionHandler(Exception.class)
	public String exceptionHandler2(Exception e)
	{
		return "Invalid request";
	}
	
}
