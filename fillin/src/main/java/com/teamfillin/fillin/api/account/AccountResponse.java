package com.teamfillin.fillin.api.account;

import org.jetbrains.annotations.NotNull;

import com.teamfillin.fillin.domain.account.AccountAccessResult;
import com.teamfillin.fillin.domain.account.SocialType;
import com.teamfillin.fillin.domain.account.token.TokenResult;

import lombok.AccessLevel;
import lombok.Builder;

public class AccountResponse {
	private final SocialType type;
	private final String nickname;
	private final String accessToken;
	private final String refreshToken;

	@Builder(access = AccessLevel.PACKAGE)
	private AccountResponse(
		@NotNull SocialType type,
		@NotNull String nickname,
		@NotNull String accessToken,
		@NotNull String refreshToken
	) {
		this.type = type;
		this.nickname = nickname;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public SocialType getType() {
		return type;
	}

	public String getNickname() {
		return nickname;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public static AccountResponse from(
		@NotNull AccountAccessResult accountAccessResult,
		@NotNull TokenResult tokenResult
	) {
		return AccountResponse.builder()
			.type(accountAccessResult.getSocialType())
			.nickname(accountAccessResult.getNickname())
			.accessToken(tokenResult.getAccessToken())
			.refreshToken(tokenResult.getRefreshToken())
			.build();
	}
}
