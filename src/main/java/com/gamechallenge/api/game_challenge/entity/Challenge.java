package com.gamechallenge.api.game_challenge.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	@Enumerated(EnumType.STRING)
	private ChallengeDifficulty difficulty;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ChallengeStatus status;
}
