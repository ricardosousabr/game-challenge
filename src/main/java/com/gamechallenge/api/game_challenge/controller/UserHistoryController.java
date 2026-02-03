package com.gamechallenge.api.game_challenge.controller;

import com.gamechallenge.api.game_challenge.dto.ChallengeHistory;
import com.gamechallenge.api.game_challenge.service.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserHistoryController {
	
	@Autowired
	UserHistoryService userHistoryService;
	
	@GetMapping("/{userId/history}")
	public ResponseEntity<List<ChallengeHistory>> getHistory(@PathVariable Long userId) {
		List<ChallengeHistory> history = userHistoryService.userHistory(userId);
		
		return ResponseEntity.ok(history);
	}
}
