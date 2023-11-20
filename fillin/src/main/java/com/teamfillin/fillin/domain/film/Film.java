package com.teamfillin.fillin.domain.film;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false)
	private Long typeNo;

	@Column(nullable = false)
	private Long companyNo;

	protected Film() {
	}

	public Film(String name, Long typeNo, Long companyNo) {
		this.name = name;
		this.typeNo = typeNo;
		this.companyNo = companyNo;
	}
}
