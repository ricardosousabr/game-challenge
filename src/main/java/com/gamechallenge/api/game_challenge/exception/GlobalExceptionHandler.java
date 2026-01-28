package com.gamechallenge.api.game_challenge.exception;

import com.gamechallenge.api.game_challenge.dto.ErrorResponse;
import com.gamechallenge.api.game_challenge.entity.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
		ErrorCode errorCode = ex.getErrorCode();
		
		ErrorResponse response = new ErrorResponse(errorCode.getStatus().value(), errorCode.name(), ex.getMessage());
		
		return ResponseEntity.status(errorCode.getStatus()).body(response);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
		ErrorResponse response = new ErrorResponse(500, ErrorCode.INTERNAL_ERROR.name(), ErrorCode.INTERNAL_ERROR.getDefaultMessage());
		
		return ResponseEntity.status(500).body(response);
	}
	
}
