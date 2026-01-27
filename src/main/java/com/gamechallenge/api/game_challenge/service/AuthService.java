package com.gamechallenge.api.game_challenge.service;

import com.gamechallenge.api.game_challenge.dto.AuthLogin;
import com.gamechallenge.api.game_challenge.dto.RegisterDTO;
import com.gamechallenge.api.game_challenge.entity.User;
import com.gamechallenge.api.game_challenge.repository.UserRepository;
import com.gamechallenge.api.game_challenge.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	TokenService tokenService;
	
	public void register(RegisterDTO data) {
		if (userRepository.findByEmail(data.email()).isPresent()) {
			throw new RuntimeException("Email already registered");
		}
		
		User newUser = new User(data.userName(), data.email(), data.password(), data.role());
		userRepository.save(newUser);
	}
	
	public String login(AuthLogin data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		return tokenService.generateToken((User) Objects.requireNonNull(auth.getPrincipal()));
	}
}
