package com.teamfillin.fillin.domain.film;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "film_type")
public class FilmTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false, length = 50)
	private String name;

	protected FilmTypeEntity() {
	}

	@NotNull
	public Long getNo() {
		return no;
	}

	@NotNull
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			FilmTypeEntity target = (FilmTypeEntity)obj;
			return Objects.equals(no, target.no);
		}
		return false;
	}
}
