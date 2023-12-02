package com.teamfillin.fillin.domain.studio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

@Entity
@Table(name = "studio")
public class StudioEntity {

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
	private StudioStatus status; // studio 가 더 이상 장사를 하지 않는건지 판단하는 경우에만 필요할듯

	protected StudioEntity() {
	}

	@Builder
	private StudioEntity(String name, String address, String tel, Double latitude, Double longitude,
		String etc, String site, StudioStatus status) {
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.latitude = latitude;
		this.longitude = longitude;
		this.etc = etc;
		this.site = site;
		this.status = status;
	}

	public Long getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getTel() {
		return tel;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public String getEtc() {
		return etc;
	}

	public String getSite() {
		return site;
	}

	public StudioStatus getStatus() {
		return status;
	}
}
