package com.teamfillin.fillin.domain.studio;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;

import com.teamfillin.fillin.FillinErrorCode;

enum StudioErrorCode implements FillinErrorCode {

	E404_STUDIO_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 스튜디오입니다"),
	;

	private final HttpStatus status;
	private final String defaultMessage;

	StudioErrorCode(HttpStatus status, String defaultMessage) {
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
