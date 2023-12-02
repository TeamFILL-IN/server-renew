package com.teamfillin.fillin.domain.studio.view;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

public abstract class RunningTimeInfoFormatter {

	protected static final String SPACE = " ";
	protected static final String DASH = " - ";
	protected static final String LINE_BREAK = "\n";

	protected final RunningTime runningTime;

	protected RunningTimeInfoFormatter(RunningTime runningTime) {
		this.runningTime = runningTime;
	}

	public abstract String format();
}
