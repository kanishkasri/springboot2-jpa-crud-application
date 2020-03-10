package com.springboot2angular.springboot2jpacrudapplication.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/*
 * The@ControllerAdvice annotation allows us to consolidate our multiple,
 * scattered @ExceptionHandlers from before into a single, global error handling
 * component.
 * Full control over the body of the response as well as the status code 
 * Mapping of several exceptions to the same method, to be handled together, and 
 * It makes good use of the newer RESTful ResposeEntity response
 * 
 * One thing to keep in mind here is to match the exceptions declared with @ExceptionHandler 
 * with the exception used as the argument of the method.
 * 
 * https://www.baeldung.com/exception-handling-for-rest-with-spring
 */

@ControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * @ExceptionHandler @Controller level – we will define a method to handle
	 * exceptions, and annotate that with @ExceptionHandler.
	 */

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourseNotFoundException(ResourceNotFoundException ex, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
