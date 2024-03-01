package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;

import com.teamfillin.fillin.domain.user.User;

public class AccountAndUser {
	private final Account account;
	private final User user;

	AccountAndUser(@NotNull final Account account, @NotNull final User user) {
		this.account = account;
		this.user = user;
	}

	@NotNull
	public SocialType getSocialType() {
		return account.getSocialType();
	}

	@NotNull
	public String getSocialId() {
		return account.getSocialId();
	}

	public long getAccountNo() {
		return account.getNo();
	}

	public long getUserNo() {
		return user.getNo();
	}

	@NotNull
	public String getNickname() {
		return user.getNickname();
	}
}
