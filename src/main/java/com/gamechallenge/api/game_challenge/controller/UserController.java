package com.gamechallenge.api.game_challenge.controller;

import com.gamechallenge.api.game_challenge.dto.ChallengeCompletionResponse;
import com.gamechallenge.api.game_challenge.service.UserChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserChallengeService userChallengeService;
	
	@PostMapping("{userId}/challenge/{userChallenge}/complete")
	public ResponseEntity<ChallengeCompletionResponse> completeChallenge(@PathVariable Long userId, @PathVariable Long userChallenge) {
		var response = userChallengeService.completeChallenge(userId, userChallenge);
		
		return ResponseEntity.ok(response);
	}
}
