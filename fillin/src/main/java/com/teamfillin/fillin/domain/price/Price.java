package com.teamfillin.fillin.domain.price;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Price {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false)
	private Long studioNo;

	@Column(length = 100)
	private String name;

	private Integer price;

	protected Price() {
	}
}
