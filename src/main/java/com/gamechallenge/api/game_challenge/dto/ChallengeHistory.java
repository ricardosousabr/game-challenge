package com.gamechallenge.api.game_challenge.dto;

import com.gamechallenge.api.game_challenge.entity.UserChallengeStatus;

import java.util.Date;

public record ChallengeHistory(Long challengeId, String title, UserChallengeStatus status, int xp, Date completeAt) {
}
