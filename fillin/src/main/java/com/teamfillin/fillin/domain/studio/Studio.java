package com.teamfillin.fillin.domain.studio;

import java.util.Objects;

import lombok.AccessLevel;
import lombok.Builder;

public class Studio {

	private final long no;
	private final String name;
	private final String address;
	private final String tel;
	private final StudioLocation location;
	private final String etc;
	private final String site;
	private final StudioStatus status;

	@Builder(access = AccessLevel.PACKAGE)
	private Studio(long no, String name, String address, String tel, StudioLocation location, String etc,
		String site, StudioStatus status) {
		this.no = no;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.location = location;
		this.etc = etc;
		this.site = site;
		this.status = status;
	}

	public static Studio from(StudioEntity studioEntity) {
		StudioLocation location = StudioLocation.builder()
			.longitude(studioEntity.getLongitude())
			.latitude(studioEntity.getLatitude())
			.build();
		return Studio.builder()
			.no(studioEntity.getNo())
			.name(studioEntity.getName())
			.address(studioEntity.getAddress())
			.tel(studioEntity.getTel())
			.location(location)
			.etc(studioEntity.getEtc())
			.site(studioEntity.getSite())
			.status(studioEntity.getStatus())
			.build();
	}

	public long getNo() {
		return no;
	}

	public double getLatitude() {
		return location.getLatitude();
	}

	public double getLongitude() {
		return location.getLongitude();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Studio studio = (Studio)o;
		return no == studio.no && Objects.equals(name, studio.name) && Objects.equals(address,
			studio.address) && Objects.equals(tel, studio.tel) && Objects.equals(location,
			studio.location) && Objects.equals(etc, studio.etc) && Objects.equals(site, studio.site)
			&& status == studio.status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no, name, address, tel, location, etc, site, status);
	}
}
