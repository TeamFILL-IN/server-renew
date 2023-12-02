package com.teamfillin.fillin.domain.runningTime.view;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

class OnlyOnlineRunningTimeInfoFormatter extends RunningTimeInfoFormatter {

	OnlyOnlineRunningTimeInfoFormatter(RunningTime runningTime) {
		super(runningTime);
	}

	@Override
	public String format() {
		return runningTime.getOperationStatus().getValue();
	}
}
