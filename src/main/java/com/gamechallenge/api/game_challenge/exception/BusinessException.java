package com.gamechallenge.api.game_challenge.exception;

import com.gamechallenge.api.game_challenge.entity.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
	private final ErrorCode errorCode;
	
	public BusinessException(ErrorCode errorCode) {
		super(errorCode.getDefaultMessage());
		this.errorCode = errorCode;
	}
}
