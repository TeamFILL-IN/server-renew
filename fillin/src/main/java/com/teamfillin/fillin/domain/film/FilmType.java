package com.teamfillin.fillin.domain.film;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public class FilmType {
	private final long no;
	private final String name;

	public FilmType(long no, @NotNull String name) {
		this.no = no;
		this.name = name;
	}

	public static FilmType from(@NotNull FilmTypeEntity filmTypeEntity) {
		return new FilmType(filmTypeEntity.getNo(), filmTypeEntity.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(no, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			FilmType target = (FilmType)obj;
			return Objects.equals(no, target.no) && Objects.equals(name, target.name);
		}
		return false;
	}
}
