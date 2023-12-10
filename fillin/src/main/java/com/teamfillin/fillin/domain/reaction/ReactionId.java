package com.teamfillin.fillin.domain.reaction;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public class ReactionId {
	private final TargetType type;
	private final long targetNo;

	public ReactionId(@NotNull TargetType type, long targetNo) {
		this.type = type;
		this.targetNo = targetNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, targetNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			ReactionId target = (ReactionId)obj;
			return type == target.type && targetNo == target.targetNo;
		}
		return false;
	}
}
