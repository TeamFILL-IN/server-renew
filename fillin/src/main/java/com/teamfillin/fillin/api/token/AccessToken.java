package com.teamfillin.fillin.api.token;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import lombok.Builder;

public class AccessToken {
	@NotNull
	private final TokenType type;
	@NotNull
	private final String value;

	@Builder
	private AccessToken(@NotNull TokenType tokenType, @NotNull String value) {
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
			AccessToken target = (AccessToken)obj;
			return type == target.type && Objects.equals(value, target.type);
		}
		return false;
	}
}
