package com.teamfillin.fillin.domain.reaction;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public class LikeReaction {
	private final ReactionId reactionId;
	private final long count;

	public LikeReaction(@NotNull ReactionId reactionId, long count) {
		this.reactionId = reactionId;
		this.count = count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reactionId, count);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			LikeReaction target = (LikeReaction)obj;
			return Objects.equals(reactionId, target.reactionId) && count == target.count;
		}
		return false;
	}
}
