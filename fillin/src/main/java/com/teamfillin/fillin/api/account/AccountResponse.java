package com.teamfillin.fillin.api.account;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.teamfillin.fillin.domain.account.AccountAccessResult;
import com.teamfillin.fillin.domain.account.SocialType;
import com.teamfillin.fillin.domain.account.token.AccessToken;

import lombok.AccessLevel;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {
	private final SocialType type;
	private final String nickname;
	private final String accessToken;
	@Nullable
	private final String refreshToken;

	@Builder(access = AccessLevel.PACKAGE)
	private AccountResponse(SocialType type, String nickname, String accessToken, @Nullable String refreshToken) {
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
		@NotNull AccessToken accessToken
	) {
		return AccountResponse.builder()
			.type(accountAccessResult.getSocialType())
			.nickname(accountAccessResult.getNickname())
			.accessToken(accessToken.getValue())
			.build();
	}
}
