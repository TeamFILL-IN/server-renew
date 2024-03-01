package com.teamfillin.fillin.api.token;

import org.jetbrains.annotations.NotNull;

import com.teamfillin.fillin.domain.account.AccountAccessResult;

public interface TokenHandler {
	public AccessToken generateAccessTokenFrom(@NotNull final AccountAccessResult accountAccessResult);
}
