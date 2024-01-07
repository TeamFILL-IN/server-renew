package com.teamfillin.fillin.domain.studio;

public class StudioSearchResult {

	private final long id;
	private final String name;
	private final String address;

	private StudioSearchResult(long id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public static StudioSearchResult from(Studio studio) {
		return new StudioSearchResult(studio.getNo(), studio.getName(), studio.getAddress());
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
}
