package com.teamfillin.fillin.api.account;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamfillin.fillin.api.FillinApiResponse;
import com.teamfillin.fillin.domain.account.AccountAccessResult;
import com.teamfillin.fillin.domain.account.AccountService;
import com.teamfillin.fillin.domain.account.SocialType;
import com.teamfillin.fillin.domain.account.token.AccessToken;
import com.teamfillin.fillin.domain.account.token.JwtTokenHandler;

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
	public ResponseEntity<FillinApiResponse> loginOrJoin(
		@RequestBody AccountRequest accountRequest
	) {
		final SocialType socialType = accountRequest.getSocial();
		final String idKey = accountRequest.getIdKey();

		final AccountAccessResult accountAccessResult = accountService.loginOrJoin(socialType, idKey);
		final AccessToken accessToken = jwtTokenHandler.generateAccessTokenFrom(accountAccessResult);

		return switch (accountAccessResult.getProcedure()) {
			case JOIN ->
				FillinApiResponse.success(HttpStatus.CREATED, AccountResponse.from(accountAccessResult, accessToken));
			case LOGIN -> // Client 에 해당 api 200 상태코드 적용 가능 여부 확인 필요!
				FillinApiResponse.success(HttpStatus.OK, AccountResponse.from(accountAccessResult, accessToken));
		};
	}
}