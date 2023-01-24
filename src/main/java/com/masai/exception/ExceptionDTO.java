package com.masai.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionDTO {
	
	private LocalDateTime dateAndTime;
	
	private String message;
	
	private String description;
	
}
