package com.gamechallenge.api.game_challenge.dto;

import com.gamechallenge.api.game_challenge.entity.UserChallengeStatus;

import java.util.Date;

public record ChallengeCompletionResponse(Long userId, Long challengeId, int xpGained, int totalXp, int level, UserChallengeStatus status, Date completedAt) {}
