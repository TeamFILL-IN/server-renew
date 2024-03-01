package com.teamfillin.fillin.domain.reaction;

public class ReactionCreateCommand {

	private final long userNo;
	private final long targetNo;

	public ReactionCreateCommand(long userNo, long targetNo) {
		this.userNo = userNo;
		this.targetNo = targetNo;
	}

	public long getUserNo() {
		return userNo;
	}

	public long getTargetNo() {
		return targetNo;
	}
}
