package com.teamfillin.fillin.domain.account.token;

import org.jetbrains.annotations.NotNull;

import lombok.AccessLevel;
import lombok.Builder;

public class TokenResult {
	@NotNull
	private final String accessToken;

	@NotNull
	private final String refreshToken;

	@Builder(access = AccessLevel.PACKAGE)
	private TokenResult(@NotNull String accessToken, @NotNull String refreshToken) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	@NotNull
	public String getAccessToken() {
		return accessToken;
	}

	@NotNull
	public String getRefreshToken() {
		return refreshToken;
	}
}
