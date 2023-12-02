package com.teamfillin.fillin.domain.studio.view;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

public class OnlyOnlineRunningTimeInfoFormatter extends RunningTimeInfoFormatter {

	protected OnlyOnlineRunningTimeInfoFormatter(RunningTime runningTime) {
		super(runningTime);
	}

	@Override
	public String format() {
		return runningTime.getOperationStatus().getValue();
	}
}
