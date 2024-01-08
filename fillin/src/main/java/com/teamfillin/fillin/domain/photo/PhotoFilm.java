package com.teamfillin.fillin.domain.photo;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import com.teamfillin.fillin.domain.film.Film;

public class PhotoFilm {
	private final Film film;

	public PhotoFilm(@NotNull Film film) {
		this.film = film;
	}

	@Override
	public int hashCode() {
		return Objects.hash(film);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			PhotoFilm target = (PhotoFilm)obj;
			return Objects.equals(film, target.film);
		}
		return false;
	}
}
