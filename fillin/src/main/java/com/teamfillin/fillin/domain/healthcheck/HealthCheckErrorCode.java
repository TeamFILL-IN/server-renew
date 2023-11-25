package com.teamfillin.fillin.domain.healthcheck;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;

import com.teamfillin.fillin.FillinErrorCode;

public enum HealthCheckErrorCode implements FillinErrorCode {
	E400_HEALTH_CHECK_BAD_REQUEST(HttpStatus.BAD_REQUEST, "health check fail.");

	@NotNull
	private final HttpStatus status;

	@Nullable
	private final String defaultMessage;

	HealthCheckErrorCode(HttpStatus status, String defaultMessage) {
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
