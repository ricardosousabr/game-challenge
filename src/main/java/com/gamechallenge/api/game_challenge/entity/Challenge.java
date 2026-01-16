package com.gamechallenge.api.game_challenge.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "challenge")
public class Challenge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private int xp;
	
	@Column(nullable = false)
	@Enumerated
	private ChallengeDifficulty difficulty;
	
	@Column(nullable = false)
	@Enumerated
	private ChallengeStatus status;
}
