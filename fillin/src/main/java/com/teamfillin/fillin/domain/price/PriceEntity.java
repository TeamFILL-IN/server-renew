package com.teamfillin.fillin.domain.price;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false)
	private Long studioNo;

	@Column(length = 100)
	private String name;

	private Integer amount;

	protected PriceEntity() {
	}
}
