package com.teamfillin.fillin.api.token;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import lombok.AccessLevel;
import lombok.Builder;

public class RefreshToken {
	@NotNull
	private final TokenType type;
	@NotNull
	private final String value;

	@Builder(access = AccessLevel.PACKAGE)
	private RefreshToken(@NotNull TokenType tokenType, @NotNull String value) {
		this.type = tokenType;
		this.value = value;
	}

	@NotNull
	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			RefreshToken target = (RefreshToken)obj;
			return type == target.type && Objects.equals(value, target.type);
		}
		return false;
	}
}
