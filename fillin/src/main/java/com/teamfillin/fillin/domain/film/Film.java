package com.teamfillin.fillin.domain.film;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public class Film {
	private final long no;
	private final FilmType type;
	private final String name;
	private final Company company;

	public Film(long no, @NotNull FilmType type, @NotNull String name, @NotNull Company company) {
		this.no = no;
		this.type = type;
		this.name = name;
		this.company = company;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no, type, name, company);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Film target = (Film)obj;
			return Objects.equals(no, target.no)
				&& Objects.equals(name, target.name)
				&& Objects.equals(type, target.type)
				&& Objects.equals(company, target.company);
		}
		return false;
	}
}
