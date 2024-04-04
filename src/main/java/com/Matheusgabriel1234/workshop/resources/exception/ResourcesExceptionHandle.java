package com.Matheusgabriel1234.workshop.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Matheusgabriel1234.workshop.service.exception.ObjectNotFound;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourcesExceptionHandle {
@ExceptionHandler(ObjectNotFound.class)
public ResponseEntity<StandardError> objectNotFound(ObjectNotFound e,HttpServletRequest req){
	HttpStatus status = HttpStatus.NOT_FOUND;
	StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"não encontrado",e.getMessage(),req.getRequestURI());
	return ResponseEntity.status(status).body(err);
}
}
