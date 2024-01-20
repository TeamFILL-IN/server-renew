package com.teamfillin.fillin.domain.film;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public class Company {
	private final long no;
	private final String name;

	public Company(long no, @NotNull String name) {
		this.no = no;
		this.name = name;
	}

	public static Company from(@NotNull CompanyEntity companyEntity) {
		return new Company(companyEntity.getNo(), companyEntity.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(no, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Company target = (Company)obj;
			return Objects.equals(no, target.no) && Objects.equals(name, target.name);
		}
		return false;
	}
}
