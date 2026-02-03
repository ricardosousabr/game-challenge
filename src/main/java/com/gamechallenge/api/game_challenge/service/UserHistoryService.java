package com.gamechallenge.api.game_challenge.service;

import com.gamechallenge.api.game_challenge.dto.ChallengeHistory;
import com.gamechallenge.api.game_challenge.entity.UserChallenge;
import com.gamechallenge.api.game_challenge.entity.UserChallengeStatus;
import com.gamechallenge.api.game_challenge.repository.UserChallengeRepository;
import com.gamechallenge.api.game_challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHistoryService {
	@Autowired
	UserChallengeRepository userChallengeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<ChallengeHistory> userHistory(Long idUser) {
		if (!userRepository.existsById(idUser)) {
			throw new RuntimeException("User not found");
		}
		
		List<UserChallenge> getHistory = userChallengeRepository.findByUserIdAndStatus(idUser, UserChallengeStatus.COMPLETED);
		
		return getHistory.stream().map(
				userChallenge -> new ChallengeHistory(
						userChallenge.getChallenge().getId(),
						userChallenge.getChallenge().getTitle(),
						userChallenge.getStatus(),
						userChallenge.getXp(),
						userChallenge.getCompletedAt())
		).toList();
	}
}
