package com.teamfillin.fillin.domain.film;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD

import org.jetbrains.annotations.NotNull;
=======
>>>>>>> ce7b2c8 (entity 에 table name 적용)

@Entity
@Table(name = "film")
public class FilmEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false)
	private Long typeNo;

	@Column(nullable = false)
	private Long companyNo;

	protected FilmEntity() {
	}

	@NotNull
	public Long getNo() {
		return no;
	}

	@NotNull
	public String getName() {
		return name;
	}

	@NotNull
	public Long getTypeNo() {
		return typeNo;
	}

	@NotNull
	public Long getCompanyNo() {
		return companyNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			FilmEntity target = (FilmEntity)obj;
			return Objects.equals(no, target.no);
		}
		return false;
	}
}
