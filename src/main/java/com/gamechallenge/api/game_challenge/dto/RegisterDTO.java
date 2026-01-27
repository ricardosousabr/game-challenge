package com.gamechallenge.api.game_challenge.dto;

import com.gamechallenge.api.game_challenge.entity.UserRole;

public record RegisterDTO(String userName, String email, String password, UserRole role) {
}
