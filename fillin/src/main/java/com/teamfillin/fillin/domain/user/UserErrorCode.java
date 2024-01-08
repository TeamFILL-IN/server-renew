package com.teamfillin.fillin.domain.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;

import com.teamfillin.fillin.FillinErrorCode;

enum UserErrorCode implements FillinErrorCode {
	E404_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "계정을 찾지못했습니다.");

	private final HttpStatus status;
	private final String defaultMessage;

	UserErrorCode(HttpStatus status, String defaultMessage) {
		this.status = status;
		this.defaultMessage = defaultMessage;
	}

	@NotNull
	@Override
	public HttpStatus status() {
		return status;
	}

	@Nullable
	@Override
	public String defaultMessage() {
		return defaultMessage;
	}
}
