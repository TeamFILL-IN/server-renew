package com.teamfillin.fillin.domain.studio;

import java.util.Objects;

import lombok.AccessLevel;
import lombok.Builder;

public class StudioLocation {

	private final double latitude;
	private final double longitude;

	@Builder(access = AccessLevel.PACKAGE)
	private StudioLocation(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		StudioLocation that = (StudioLocation)o;
		return Double.compare(that.latitude, latitude) == 0
			&& Double.compare(that.longitude, longitude) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitude, longitude);
	}
}
