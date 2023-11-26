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
@Table(name = "company")
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false, length = 50)
	private String name;

	protected CompanyEntity() {
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
			CompanyEntity target = (CompanyEntity)obj;
			return Objects.equals(no, target.no);
		}
		return false;
	}
}
