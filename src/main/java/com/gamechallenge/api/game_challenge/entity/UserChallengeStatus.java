package com.gamechallenge.api.game_challenge.entity;

public enum UserChallengeStatus {
	PENDING("pending"),
	IN_PROGRESS("in_progress"),
	COMPLETED("completed");
	
	private final String status;
	
	UserChallengeStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
