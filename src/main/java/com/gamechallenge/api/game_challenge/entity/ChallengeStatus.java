package com.gamechallenge.api.game_challenge.entity;

public enum ChallengeStatus {
	INACTIVE("inactive"),
	ACTIVE("active");
	
	private final String status;
	
	ChallengeStatus(String status){
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
