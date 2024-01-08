package com.teamfillin.fillin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.util.StringUtils;

import lombok.Builder;

public class FillinException extends RuntimeException {
	@NotNull
	protected final FillinErrorCode errorCode;

	@Nullable
	protected final String message;

	@Nullable
	protected final String log;

	private FillinException(@NotNull FillinErrorCode errorCode) {
		super(makeMessage(errorCode, null));
		this.errorCode = errorCode;
		this.message = errorCode.defaultMessage();
		this.log = null;
	}

	@Builder
	private FillinException(@NotNull FillinErrorCode errorCode, @Nullable String message, @Nullable String log) {
		super(makeMessage(errorCode, message));
		this.errorCode = errorCode;
		this.log = log;
		this.message = StringUtils.hasText(message) ? message : errorCode.defaultMessage();
	}

	public static FillinException from(@NotNull FillinErrorCode errorCode) {
		return new FillinException(errorCode);
	}

	private static String makeMessage(@NotNull FillinErrorCode errorCode, @Nullable String detailMessage) {
		return StringUtils.hasText(detailMessage)
			? errorCode.name() + ": " + detailMessage
			: StringUtils.hasText(errorCode.defaultMessage())
			? errorCode.name() + ": " + errorCode.defaultMessage()
			: errorCode.name();
	}

	@NotNull
	public FillinErrorCode getErrorCode() {
		return errorCode;
	}

	@Nullable
	public String getLog() {
		return log;
	}

	@Override
	public String toString() {
		return message != null
			? errorCode.name() + ": " + message
			: StringUtils.hasText(errorCode.defaultMessage())
			? errorCode.name() + ": " + errorCode.defaultMessage()
			: errorCode.name();
	}
}
