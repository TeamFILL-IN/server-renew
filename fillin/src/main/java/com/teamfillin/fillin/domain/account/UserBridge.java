package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import com.teamfillin.fillin.domain.user.User;
import com.teamfillin.fillin.domain.user.UserRegister;
import com.teamfillin.fillin.domain.user.UserRetriever;

@Component
public class UserBridge {
	private final UserRegister userRegister;
	private final UserRetriever userRetriever;

	public UserBridge(UserRegister userRegister, UserRetriever userRetriever) {
		this.userRegister = userRegister;
		this.userRetriever = userRetriever;
	}

	@NotNull
	public User retrieveUser(final long userNo) {
		return userRetriever.retrieve(userNo);
	}

	@NotNull
	public User registerUser() {
		return userRegister.registerUser();
	}
}
