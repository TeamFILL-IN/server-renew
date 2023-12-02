package com.teamfillin.fillin.domain.runningTime.view;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

class OpenRunningTimeInfoFormatter extends RunningTimeInfoFormatter {

	OpenRunningTimeInfoFormatter(RunningTime runningTime) {
		super(runningTime);
	}

	@Override
	public String format() {
		return runningTime.getDayOfWeek()
			+ SPACE
			+ runningTime.getStartAt()
			+ DASH
			+ runningTime.getEndAt();
	}
}
