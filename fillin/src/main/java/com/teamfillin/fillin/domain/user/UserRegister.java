package com.teamfillin.fillin.domain.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserRegister {
	private final NicknameGenerator nicknameGenerator;
	private final UserRepository userRepository;

	public UserRegister(
		NicknameGenerator nicknameGenerator
		, UserRepository userRepository
	) {
		this.nicknameGenerator = nicknameGenerator;
		this.userRepository = userRepository;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public User registerUser() {
		final String randomNickname = generateRandomNickname();
		final UserEntity registeredUserEntity = userRepository.save(UserEntity.createActive(randomNickname));

		return User.from(registeredUserEntity);
	}

	@NotNull
	private String generateRandomNickname() {
		return nicknameGenerator.makeByRule();
	}
}
