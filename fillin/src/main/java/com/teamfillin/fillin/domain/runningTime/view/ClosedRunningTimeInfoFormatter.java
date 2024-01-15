package com.teamfillin.fillin.domain.runningTime.view;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

class ClosedRunningTimeInfoFormatter extends RunningTimeInfoFormatter {

	ClosedRunningTimeInfoFormatter(RunningTime runningTime) {
		super(runningTime);
	}

	@Override
	public String format() {
		return runningTime.getDayOfWeek() + SPACE + runningTime.getOperationStatus().getValue();
	}
}
