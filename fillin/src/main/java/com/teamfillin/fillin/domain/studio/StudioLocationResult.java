package com.teamfillin.fillin.domain.studio;

public class StudioLocationResult {

	private final long id;
	private final double latitude;
	private final double longitude;

	private StudioLocationResult(long id, double latitude, double longitude) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public static StudioLocationResult from(Studio studio) {
		return new StudioLocationResult(studio.getNo(), studio.getLatitude(), studio.getLongitude());
	}

	public long getId() {
		return id;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}
}
