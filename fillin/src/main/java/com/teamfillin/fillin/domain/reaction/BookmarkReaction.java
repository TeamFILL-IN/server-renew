package com.teamfillin.fillin.domain.reaction;

import org.jetbrains.annotations.NotNull;

public class BookmarkReaction {

	private final ReactionId reactionId;
	private final StudioInfo studioInfo;

	private BookmarkReaction(ReactionId reactionId, StudioInfo studioInfo) {
		this.reactionId = reactionId;
		this.studioInfo = studioInfo;
	}

	public static BookmarkReaction of(@NotNull ReactionId reactionId, String name, String address) {
		return new BookmarkReaction(reactionId, new StudioInfo(name, address));
	}

	private static class StudioInfo {

		private final String name;
		private final String address;

		StudioInfo(String name, String address) {
			this.name = name;
			this.address = address;
		}
	}

	public long getTargetNo() {
		return reactionId.getTargetNo();
	}

	public String getName() {
		return studioInfo.name;
	}

	public String getAddress() {
		return studioInfo.address;
	}
}
