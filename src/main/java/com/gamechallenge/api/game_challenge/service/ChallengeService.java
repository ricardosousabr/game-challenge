package com.gamechallenge.api.game_challenge.service;

import com.gamechallenge.api.game_challenge.entity.Challenge;
import com.gamechallenge.api.game_challenge.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
	
	@Autowired
	ChallengeRepository challengeRepository;
	
	public Optional<Challenge> getChallengeById(Long id) {
		return challengeRepository.findById(id);
	}
	
	public List<Challenge> getAllChallenges() {
		return challengeRepository.findAll();
	}
}
