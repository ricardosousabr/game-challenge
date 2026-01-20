package com.gamechallenge.api.game_challenge.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_challenge")
public class UserChallenge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn
	@ManyToOne
	private User user;
	
	@JoinColumn
	@ManyToOne
	private Challenge challenge;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UserChallengeStatus status;
	
	@Column(nullable = false)
	private int xp;
	
	@Column(nullable = false)
	private Date createdAt;
	
	@Column
	private Date startedAt;
	
	@Column
	private Date completedAt;
}
