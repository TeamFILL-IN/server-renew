package com.teamfillin.fillin.resource;

import java.util.Objects;

public class ImageUrl {
	private final String domain;
	private final String path;

	public ImageUrl(String domain, String path) {
		this.domain = domain;
		this.path = path;
	}

	@Override
	public int hashCode() {
		return Objects.hash(domain, path);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			ImageUrl target = (ImageUrl)obj;
			return Objects.equals(domain, target.domain) && Objects.equals(path, target.path);
		}
		return false;
	}
}
