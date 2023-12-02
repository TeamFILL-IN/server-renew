package com.teamfillin.fillin.domain.studio.view;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

public class OpenRunningTimeInfoFormatter extends RunningTimeInfoFormatter {

	protected OpenRunningTimeInfoFormatter(RunningTime runningTime) {
		super(runningTime);
	}

	@Override
	public String format() {
		return runningTime.getDayOfWeek() + SPACE + runningTime.getStartAt() + DASH + runningTime.getEndAt();
	}
}
