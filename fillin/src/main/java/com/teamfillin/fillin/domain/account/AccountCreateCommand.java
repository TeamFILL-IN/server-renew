package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;

public class AccountCreateCommand {
	private final SocialType socialType;
	private final String idKey;

	public AccountCreateCommand(@NotNull final SocialType socialType, @NotNull final String idKey) {
		this.socialType = socialType;
		this.idKey = idKey;
	}

	public SocialType getSocialType() {
		return socialType;
	}

	public String getIdKey() {
		return idKey;
	}
}
