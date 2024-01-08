package com.teamfillin.fillin.domain.photo;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import com.teamfillin.fillin.domain.reaction.LikeReaction;

public class PhotoLikeReaction {
	private final LikeReaction reaction;

	public PhotoLikeReaction(@NotNull LikeReaction reaction) {
		this.reaction = reaction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reaction);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			PhotoLikeReaction target = (PhotoLikeReaction)obj;
			return Objects.equals(reaction, target.reaction);
		}
		return false;
	}
}
