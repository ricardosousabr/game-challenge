package com.gamechallenge.api.game_challenge.controller;

import com.gamechallenge.api.game_challenge.dto.AuthLogin;
import com.gamechallenge.api.game_challenge.dto.RegisterDTO;
import com.gamechallenge.api.game_challenge.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/register")
	 public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
		authService.register(data);
		
		return ResponseEntity.ok("Registered user");
	}

	@PostMapping("/login")
	public String login(@RequestBody @Valid AuthLogin data) {
		return authService.login(data);
		
	}
}
