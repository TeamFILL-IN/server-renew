package com.teamfillin.fillin;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpStatus;

public interface FillinErrorCode {

	@NotNull
	String name();

	@NotNull
	HttpStatus status();

	@Nullable
	String defaultMessage();
}
