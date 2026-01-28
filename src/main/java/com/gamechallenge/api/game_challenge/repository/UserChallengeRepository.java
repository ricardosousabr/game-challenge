package com.gamechallenge.api.game_challenge.repository;

import com.gamechallenge.api.game_challenge.entity.Challenge;
import com.gamechallenge.api.game_challenge.entity.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, Long> {
}
