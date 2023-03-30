package com.masai.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.masai.exception.EmployeeException;
import com.masai.exception.ExceptionDTO;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionDTO> validationExceptionHandler(MethodArgumentNotValidException excp){
		
		ExceptionDTO error = new ExceptionDTO();
		
		error.setDateAndTime(LocalDateTime.now());
		error.setMessage(excp.getMessage());
		error.setDescription(excp.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ExceptionDTO>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionDTO> nullPointerExceptionHandler(NullPointerException excp,WebRequest web){
		
		ExceptionDTO error = new ExceptionDTO();
		error.setDateAndTime(LocalDateTime.now());
		error.setMessage(excp.getMessage());
		error.setDescription(web.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(error, HttpStatus.BAD_REQUEST);
		
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDTO> masterExceptionHandler(Exception excp, WebRequest web){
		
		ExceptionDTO error = new ExceptionDTO();
		error.setDateAndTime(LocalDateTime.now());
		error.setMessage(excp.getMessage());
		error.setDescription(web.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ExceptionDTO> loginExceptionHandler(EmployeeException excp, WebRequest web){
		
		ExceptionDTO error = new ExceptionDTO();
		
		error.setDateAndTime(LocalDateTime.now());
		error.setMessage(excp.getMessage());
		error.setDescription(web.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionDTO> noHandlerFoundException(NoHandlerFoundException excp,WebRequest web){
		
		ExceptionDTO error = new ExceptionDTO();
		error.setDateAndTime(LocalDateTime.now());
		error.setMessage(excp.getMessage());
		error.setDescription(web.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(error,HttpStatus.BAD_REQUEST);
		
	}
	

}
