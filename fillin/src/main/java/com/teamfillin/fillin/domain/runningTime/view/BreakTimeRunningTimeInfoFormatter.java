package com.teamfillin.fillin.domain.runningTime.view;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

class BreakTimeRunningTimeInfoFormatter extends RunningTimeInfoFormatter {

	BreakTimeRunningTimeInfoFormatter(RunningTime runningTime) {
		super(runningTime);
	}

	@Override
	public String format() {
		return runningTime.getOperationStatus().getValue()
			+ SPACE
			+ runningTime.getStartAt()
			+ DASH
			+ runningTime.getEndAt();
	}
}
