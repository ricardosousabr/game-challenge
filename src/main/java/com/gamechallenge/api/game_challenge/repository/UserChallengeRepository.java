package com.gamechallenge.api.game_challenge.repository;

import com.gamechallenge.api.game_challenge.entity.UserChallenge;
import com.gamechallenge.api.game_challenge.entity.UserChallengeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, Long> {
	List<UserChallenge> findByUserIdAndStatus(Long idUser, UserChallengeStatus status);
}
