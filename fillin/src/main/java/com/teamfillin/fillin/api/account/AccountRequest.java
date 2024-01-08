package com.teamfillin.fillin.api.account;

import javax.validation.constraints.NotBlank;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.teamfillin.fillin.domain.account.SocialType;

public class AccountRequest {
	private String token;
	@NotBlank(message = "social 은 필수 값입니다.")
	private SocialType social;
	@NotBlank(message = "idKey 는 필수 값입니다.")
	private String idKey;

	private AccountRequest() {
	}

	AccountRequest(String token, SocialType social, String idKey) {
		this.token = token;
		this.social = social;
		this.idKey = idKey;
	}

	@Nullable
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@NotNull
	public SocialType getSocial() {
		return social;
	}

	public void setSocial(String social) {
		this.social = SocialType.valueOf(social.toUpperCase());
	}

	@NotNull
	public String getIdKey() {
		return idKey;
	}

	public void setIdKey(String idKey) {
		this.idKey = idKey;
	}
}
