package com.teamfillin.fillin.domain.runningTime.view;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

abstract class RunningTimeInfoFormatter {

	protected static final String SPACE = " ";
	protected static final String DASH = " - ";

	protected final RunningTime runningTime;

	protected RunningTimeInfoFormatter(RunningTime runningTime) {
		this.runningTime = runningTime;
	}

	public abstract String format();
}
