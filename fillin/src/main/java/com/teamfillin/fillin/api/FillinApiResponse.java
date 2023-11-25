package com.teamfillin.fillin.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.teamfillin.fillin.FillinErrorCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FillinApiResponse {
	private final int status;

	private final boolean success;

	@Nullable
	private final Object data;

	@Nullable
	private final String message;

	private FillinApiResponse(int status, boolean success) {
		this.status = status;
		this.success = success;
		this.data = null;
		this.message = null;
	}

	private FillinApiResponse(int status, boolean success, @Nullable Object data, @Nullable String message) {
		this.status = status;
		this.success = success;
		this.data = data;
		this.message = message;
	}

	public static FillinApiResponse failure(@NotNull FillinErrorCode errorCode) {
		return StringUtils.hasText(errorCode.defaultMessage())
			? failure(errorCode.status(), errorCode.defaultMessage())
			: new FillinApiResponse(errorCode.status().value(), false);
	}

	public static FillinApiResponse failure(@NotNull HttpStatus httpStatus, @NotNull String message) {
		return new FillinApiResponse(httpStatus.value(), false, null, message);
	}

	public static FillinApiResponse success() {
		return FillinApiResponse.success(HttpStatus.OK);
	}

	public static FillinApiResponse success(@NotNull HttpStatus httpStatus) {
		return new FillinApiResponse(httpStatus.value(), true);
	}

	public static FillinApiResponse success(@NotNull Object data) {
		return FillinApiResponse.success(HttpStatus.OK, data);
	}

	public static FillinApiResponse success(@NotNull HttpStatus httpStatus, @NotNull Object data) {
		return new FillinApiResponse(httpStatus.value(), true, data, null);
	}

	public static FillinApiResponse success(
		@NotNull HttpStatus httpStatus,
		@NotNull Object data,
		@Nullable String message
	) {
		return new FillinApiResponse(httpStatus.value(), true, data, message);
	}

	public static FillinApiResponse success(@NotNull HttpStatus httpStatus, @Nullable String message) {
		return new FillinApiResponse(httpStatus.value(), true, null, message);
	}

	public int getStatus() {
		return status;
	}

	public boolean isSuccess() {
		return success;
	}

	@Nullable
	public Object getData() {
		return data;
	}

	@Nullable
	public String getMessage() {
		return message;
	}
}
