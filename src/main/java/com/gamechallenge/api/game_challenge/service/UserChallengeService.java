package com.gamechallenge.api.game_challenge.service;

import com.gamechallenge.api.game_challenge.dto.ChallengeCompletionResponse;
import com.gamechallenge.api.game_challenge.entity.ErrorCode;
import com.gamechallenge.api.game_challenge.entity.User;
import com.gamechallenge.api.game_challenge.entity.UserChallenge;
import com.gamechallenge.api.game_challenge.exception.BusinessException;
import com.gamechallenge.api.game_challenge.repository.UserChallengeRepository;
import com.gamechallenge.api.game_challenge.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserChallengeService {
	
	@Autowired
	LevelService levelService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserChallengeRepository userChallengeRepository;
	
	@Transactional
	public ChallengeCompletionResponse completeChallenge(Long userId, Long userChallengeId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
		UserChallenge userChallenge = userChallengeRepository.findById(userChallengeId).orElseThrow(() -> new BusinessException(ErrorCode.INVALID_REQUEST));
		
		levelService.validateCompletion(user, userChallenge);
		levelService.markAsCompleted(userChallenge);
		int xp = levelService.calculateXpByDifficulty(userChallenge.getChallenge().getXp(), userChallenge.getChallenge().getDifficulty());
		levelService.applyXP(user, xp);
		levelService.checkAndApplyLevelUp(user);
		
		userRepository.save(user);
		userChallengeRepository.save(userChallenge);
		
		return new ChallengeCompletionResponse(user.getId(), userChallenge.getChallenge().getId(), xp, user.getXp(), user.getLevel(), userChallenge.getStatus(), userChallenge.getCompletedAt());
		
	}
}
