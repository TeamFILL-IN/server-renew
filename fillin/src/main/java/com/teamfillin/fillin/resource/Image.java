package com.teamfillin.fillin.resource;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public class Image {
	private final ImageUrl url;

	public Image(@NotNull ImageUrl url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(url);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Image target = (Image)obj;
			return Objects.equals(url, target.url);
		}
		return false;
	}
}
