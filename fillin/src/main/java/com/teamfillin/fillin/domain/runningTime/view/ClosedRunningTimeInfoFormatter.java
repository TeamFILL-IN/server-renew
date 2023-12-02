package com.teamfillin.fillin.domain.studio.view;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

public class ClosedRunningTimeInfoFormatter extends RunningTimeInfoFormatter {

	protected ClosedRunningTimeInfoFormatter(RunningTime runningTime) {
		super(runningTime);
	}

	@Override
	public String format() {
		return null;
	}
}
