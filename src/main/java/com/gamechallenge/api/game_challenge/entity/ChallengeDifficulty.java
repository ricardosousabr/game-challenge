package com.gamechallenge.api.game_challenge.entity;

public enum ChallengeDifficulty {
	EASY("easy"),
	MEDIUM("medium"),
	HARD("hard");
	
	private final String difficulty;

	ChallengeDifficulty(String difficulty){
		this.difficulty = difficulty;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
}
