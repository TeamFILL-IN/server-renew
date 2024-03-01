package com.teamfillin.fillin.domain.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserRetriever {

	private final UserRepository userRepository;

	public UserRetriever(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@NotNull
	@Transactional(readOnly = true)
	public User retrieve(final long no) {
		final UserEntity userEntity = userRepository.findById(no).orElseThrow(UserExceptionHandler::notFound);
		return User.from(userEntity);
	}
}
