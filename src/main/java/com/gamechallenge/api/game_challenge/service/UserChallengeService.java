package com.gamechallenge.api.game_challenge.service;

import com.gamechallenge.api.game_challenge.entity.User;
import com.gamechallenge.api.game_challenge.entity.UserChallenge;
import com.gamechallenge.api.game_challenge.repository.UserChallengeRepository;
import com.gamechallenge.api.game_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserChallengeService {
	
	@Autowired
	LevelService levelService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserChallengeRepository userChallengeRepository;
	
	public void completeChallenge(Long userId, Long userChallengeId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		UserChallenge userChallenge = userChallengeRepository.findById(userChallengeId).orElseThrow(() -> new RuntimeException("Error"));
		
		levelService.validateCompletion(user, userChallenge);
		levelService.markAsCompleted(userChallenge);
		int xp = levelService.calculateXpByDifficulty(userChallenge.getChallenge().getXp(), userChallenge.getChallenge().getDifficulty());
		levelService.applyXP(user, xp);
		levelService.checkAndApplyLevelUp(user);
		
		userRepository.save(user);
		userChallengeRepository.save(userChallenge);
	}
}
