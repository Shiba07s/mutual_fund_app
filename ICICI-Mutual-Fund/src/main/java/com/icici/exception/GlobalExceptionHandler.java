package com.icici.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(KycNotFoundException.class)
	public ResponseEntity<String>handlerKycNotFound(KycNotFoundException kyc){
		return new ResponseEntity<>(kyc.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(DataIntegrityViolationException.class)
	    public ResponseEntity<Object> handleDataIntegrityViolationException(
	            DataIntegrityViolationException ex, WebRequest request) {

	        Map<String, Object> body = new HashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("status", HttpStatus.CONFLICT.value());
	        body.put("error", "Data Integrity Violation");
	        body.put("message", "Duplicate entry or constraint violation");
	        body.put("details", ex.getMessage());
	        body.put("path", request.getDescription(false));

	        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
	    }

	    @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<Object> handleResourceNotFoundException(
	            ResourceNotFoundException ex, WebRequest request) {

	        Map<String, Object> body = new HashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("status", HttpStatus.NOT_FOUND.value());
	        body.put("error", "Resource Not Found");
	        body.put("message", ex.getMessage());
	        body.put("details", request.getDescription(false));

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Object> handleMethodArgumentNotValidException(
	            MethodArgumentNotValidException ex, WebRequest request) {

	        Map<String, Object> body = new HashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("status", HttpStatus.BAD_REQUEST.value());
	        body.put("error", "Validation Error");
	        body.put("message", "Validation failed for one or more fields");
	        
	        // Capture field-specific validation errors
	        Map<String, String> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
	            .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

	        body.put("fieldErrors", fieldErrors);
	        body.put("details", request.getDescription(false));

	        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handleAllOtherExceptions(
	            Exception ex, WebRequest request) {

	        Map<String, Object> body = new HashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
	        body.put("error", "Internal Server Error");
	        body.put("message", ex.getMessage());
	        body.put("details", request.getDescription(false));

	        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	    }	

}
