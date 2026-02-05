package com.gamechallenge.api.game_challenge;

import com.gamechallenge.api.game_challenge.dto.ChallengeHistory;
import com.gamechallenge.api.game_challenge.entity.Challenge;
import com.gamechallenge.api.game_challenge.entity.User;
import com.gamechallenge.api.game_challenge.entity.UserChallenge;
import com.gamechallenge.api.game_challenge.entity.UserChallengeStatus;
import com.gamechallenge.api.game_challenge.repository.ChallengeRepository;
import com.gamechallenge.api.game_challenge.repository.UserChallengeRepository;
import com.gamechallenge.api.game_challenge.repository.UserRepository;
import com.gamechallenge.api.game_challenge.service.UserHistoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserHistoryServiceTest {
	@InjectMocks
	private UserHistoryService userHistoryService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private UserChallengeRepository userChallengeRepository;
	
	@Test
	void shouldReturnCompletedChallengesHistory(){
		Long userId = 1L;
		User user = new User();
		Challenge challenge = new Challenge();
		UserChallenge userChallenge = new UserChallenge();
		
		user.setId(userId);
		
		challenge.setId(10L);
		challenge.setTitle("First challenge");
		challenge.setXp(100);
		
		userChallenge.setUser(user);
		userChallenge.setChallenge(challenge);
		userChallenge.setStatus(UserChallengeStatus.COMPLETED);
		userChallenge.setXp(100);
		userChallenge.setCompletedAt(new Date());
		
		when(userRepository.findById(userId))
				.thenReturn(Optional.of(user));
		
		when(userChallengeRepository.findByUserIdAndStatus(userId, UserChallengeStatus.COMPLETED)).thenReturn(List.of(userChallenge));
		
		
		List<ChallengeHistory> result = userHistoryService.userHistory(userId);
		
		assertEquals(1, result.size());
		
		ChallengeHistory history = result.get(0);
		
		assertEquals(10L, history.challengeId());
		assertEquals("First challenge", history.title());
		assertEquals(UserChallengeStatus.COMPLETED, history.status());
		assertEquals(100, history.xp());
	}
	
	@Test
	void shouldThrowExceptionWhenUserNotFound() {
		Long userId = 99L;
		
		when(userRepository.findById(userId)).thenReturn(Optional.empty());
		
		RuntimeException exception = assertThrows(RuntimeException.class, () -> userHistoryService.userHistory(userId));
		
		assertEquals("User not found", exception.getMessage());
	}
	
}
