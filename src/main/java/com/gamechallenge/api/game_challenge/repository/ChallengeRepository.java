package com.gamechallenge.api.game_challenge.repository;

import com.gamechallenge.api.game_challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
}
