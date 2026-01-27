package com.gamechallenge.api.game_challenge.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gamechallenge.api.game_challenge.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
	@Value("${api.security.token.secret}")
	private String secret;
	
	public String generateToken(User user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			return JWT.create()
					.withIssuer("game-challenge")
					.withSubject(user.getEmail())
					.withClaim("id", user.getId())
					.withClaim("role", user.getRole().name())
					.withExpiresAt(generateExpirationDate())
					.sign(algorithm);
			
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Error while generation token", exception);
		}
	}
	
	public DecodedJWT validateTokenAndGetClaims(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("game-challenge")
					.build()
					.verify(token);
		} catch (JWTVerificationException exception) {
			throw new RuntimeException("Token invalid");
		}
	}
	
	private Instant generateExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
