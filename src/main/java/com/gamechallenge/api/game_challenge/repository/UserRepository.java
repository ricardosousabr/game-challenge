package com.gamechallenge.api.game_challenge.repository;

import com.gamechallenge.api.game_challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
