package com.teamfillin.fillin.domain.studio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Studio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(length = 500)
	private String address;

	@Column(length = 50)
	private String tel;

	private Double latitude;

	private Double longitude;

	@Column(columnDefinition = "TEXT")
	private String etc;

	@Column(length = 500)
	private String site;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private StudioStatus status;

	protected Studio() {
	}

	public Studio(String name, String address, String tel, Double latitude, Double longitude, String etc, String site) {
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.latitude = latitude;
		this.longitude = longitude;
		this.etc = etc;
		this.site = site;
	}
}
