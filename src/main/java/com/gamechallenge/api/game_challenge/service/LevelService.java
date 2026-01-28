package com.gamechallenge.api.game_challenge.service;

import com.gamechallenge.api.game_challenge.entity.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LevelService {
	
	public void completedChallenge(Long userId, Long userChallengeId) {
	
	}

	public void validateCompletion(User user, UserChallenge userChallenge) {
		if (!userChallenge.getUser().getId().equals(user.getId())) {
			throw new IllegalStateException("Challenge does not belong to user");
		}
		
		if (userChallenge.getStatus() == UserChallengeStatus.COMPLETED) {
			throw new IllegalStateException("This challenge has already been completed");
		}
	}
	
	public void markAsCompleted(UserChallenge userChallenge) {
		userChallenge.setStatus(UserChallengeStatus.COMPLETED);
		userChallenge.setCompletedAt(new Date());
	}
	
	public int calculateXpByDifficulty(int baseXp, ChallengeDifficulty difficulty) {
		switch (difficulty) {
			case EASY -> {
				return baseXp;
			}
			case MEDIUM ->{
				return (int) (baseXp * 1.5);
			}
			case HARD -> {
				return (int) (baseXp * 2);
			}
			
			default -> {
				throw new RuntimeException("Error when calculating difficulty");
			}
		}
	}
	
	public void applyXP(User user, int xp) {
		user.setXp(user.getXp() + xp);
	}
	
	public int getForNextLevel(int level) {
		return  100 + (level * 50);
	}
	
	public void checkAndApplyLevelUp(User user) {
		while (user.getXp() >= getForNextLevel(user.getLevel())) {
			user.setLevel(user.getLevel() + 1);
		}
	}
	
}
