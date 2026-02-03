package com.gamechallenge.api.game_challenge.entity;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"),
	INVALID_REQUEST(HttpStatus.BAD_REQUEST, "Invalid request"),
	ACCESS_DENIED(HttpStatus.FORBIDDEN, "Access denied"),
	INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");
	
	private final HttpStatus status;
	private final String defaultMessage;
	
	ErrorCode(HttpStatus status, String defaultMessage) {
		this.status = status;
		this.defaultMessage = defaultMessage;
	}
}
