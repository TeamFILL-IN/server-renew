package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;

import com.teamfillin.fillin.domain.user.User;

public class AccountAndUserResult {
	private final Account account;
	private final User user;

	private AccountAndUserResult(Account account, User user) {
		this.account = account;
		this.user = user;
	}

	public static AccountAndUserResult from(@NotNull Account account, @NotNull User user) {
		return new AccountAndUserResult(account, user);
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
