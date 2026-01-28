package com.gamechallenge.api.game_challenge.dto;

public record ErrorResponse(int status, String error, String message) {}
