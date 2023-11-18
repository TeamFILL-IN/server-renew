package com.teamfillin.fillin.domain.user;

public enum SocialType {

	APPLE("애플"),
	KAKAO("카카오"),
	;

	private final String value;

	SocialType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
