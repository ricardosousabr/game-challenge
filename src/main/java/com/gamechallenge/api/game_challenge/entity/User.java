package com.gamechallenge.api.game_challenge.entity;

import jakarta.persistence.*;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	@Enumerated
	private UserRole role;
	
	@Column(nullable = false)
	private int xp;
	
	@Column(nullable = false)
	private int level;
	
	@Column(nullable = false)
	@Enumerated
	private UserStatus status;
}
