package com.teamfillin.fillin.domain.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class UserRetriever {

	private final UserRepository userRepository;

	public UserRetriever(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@NotNull
	public User retrieve(long no) {
		final UserEntity userEntity = userRepository.findById(no).orElseThrow();
		return User.from(userEntity);
	}
}
