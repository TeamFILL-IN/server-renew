package com.teamfillin.fillin.api.account;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamfillin.fillin.api.FillinApiResponse;
import com.teamfillin.fillin.domain.account.AccountAccessResult;
import com.teamfillin.fillin.domain.account.AccountService;
import com.teamfillin.fillin.domain.account.SocialType;
import com.teamfillin.fillin.domain.account.token.JwtTokenHandler;
import com.teamfillin.fillin.domain.account.token.TokenResult;

@RestController
public class AccountApi {
	private final AccountService accountService;
	private final JwtTokenHandler jwtTokenHandler;

	public AccountApi(
		AccountService accountService,
		JwtTokenHandler jwtTokenHandler
	) {
		this.accountService = accountService;
		this.jwtTokenHandler = jwtTokenHandler;
	}

	@PostMapping("/auth")
	public FillinApiResponse loginOrJoin(
		@RequestBody AccountRequest accountRequest
	) {
		final SocialType socialType = accountRequest.getSocial();
		final String idKey = accountRequest.getIdKey();

		final AccountAccessResult accountAccessResult = accountService.loginOrJoin(socialType, idKey);
		final TokenResult tokenResult = jwtTokenHandler.generateFrom(accountAccessResult);

		return FillinApiResponse.success(HttpStatus.CREATED, AccountResponse.from(accountAccessResult, tokenResult));
	}
}
