package com.teamfillin.fillin.domain.reaction;

public class BookmarkReactionResult {

	private final long studioNo;
	private final String name;
	private final String address;

	public BookmarkReactionResult(long studioNo, String name, String address) {
		this.studioNo = studioNo;
		this.name = name;
		this.address = address;
	}

	public long getStudioNo() {
		return studioNo;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
}
