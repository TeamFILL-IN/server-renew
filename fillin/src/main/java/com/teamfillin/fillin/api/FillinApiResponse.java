package com.teamfillin.fillin.api;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public static ResponseEntity<FillinApiResponse> success() {
		return success(HttpStatus.OK);
	}

	public static ResponseEntity<FillinApiResponse> success(@NotNull HttpStatus status) {
		return ResponseEntity
			.status(status)
			.body(successBody(status));
	}

	public static ResponseEntity<FillinApiResponse> success(@NotNull Object data) {
		return success(HttpStatus.OK, data);
	}

	public static ResponseEntity<FillinApiResponse> success(
		@NotNull HttpStatus httpStatus,
		@NotNull Object data,
		@Nullable String message
	) {
		return ResponseEntity
			.status(httpStatus)
			.body(successBody(httpStatus, data, message));
	}

	public static ResponseEntity<FillinApiResponse> success(@NotNull HttpStatus httpStatus, @NotNull Object data) {
		return ResponseEntity
			.status(httpStatus)
			.body(successBody(httpStatus, data));
	}

	public static ResponseEntity<FillinApiResponse> success(@NotNull HttpStatus httpStatus, @Nullable String message) {
		return ResponseEntity
			.status(httpStatus)
			.body(successBody(httpStatus, null, message));
	}

	public static ResponseEntity<FillinApiResponse> failure(@NotNull FillinErrorCode errorCode) {
		return ResponseEntity
			.status(errorCode.status())
			.body(failureBody(errorCode));
	}

	public static ResponseEntity<FillinApiResponse> failure(@NotNull FillinErrorCode errorCode,
		@NotNull String message) {
		return ResponseEntity
			.status(errorCode.status())
			.body(failureBody(errorCode.status(), message));
	}

	private static FillinApiResponse failureBody(@NotNull FillinErrorCode errorCode) {
		return StringUtils.hasText(errorCode.defaultMessage())
			? failureBody(errorCode.status(), errorCode.defaultMessage())
			: new FillinApiResponse(errorCode.status().value(), false);
	}

	private static FillinApiResponse failureBody(@NotNull HttpStatus httpStatus, @NotNull String message) {
		return new FillinApiResponse(httpStatus.value(), false, null, message);
	}

	private static FillinApiResponse successBody(@NotNull HttpStatus httpStatus) {
		return new FillinApiResponse(httpStatus.value(), true);
	}

	private static FillinApiResponse successBody(@NotNull HttpStatus httpStatus, @NotNull Object data) {
		return successBody(httpStatus, data, null);
	}

	private static FillinApiResponse successBody(
		@NotNull HttpStatus httpStatus,
		@Nullable Object data,
		@Nullable String message
	) {
		return new FillinApiResponse(httpStatus.value(), true, data, message);
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
