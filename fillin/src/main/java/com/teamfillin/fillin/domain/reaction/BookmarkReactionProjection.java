package com.teamfillin.fillin.domain.reaction;

public interface BookmarkReactionProjection {
	TargetType getType();
	long getTargetNo();
	String getName();
	String getAddress();
}
