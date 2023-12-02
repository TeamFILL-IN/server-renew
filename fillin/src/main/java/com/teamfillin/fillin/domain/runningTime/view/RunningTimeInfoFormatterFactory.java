package com.teamfillin.fillin.domain.studio.view;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

public class RunningTimeInfoFormatterFactory {

	private RunningTimeInfoFormatterFactory() {
	}

	public static RunningTimeInfoFormatter getBy(RunningTime runningTime) {
		return switch (runningTime.getOperationStatus()) {
			case OPEN -> new OpenRunningTimeInfoFormatter(runningTime);
			case CLOSED -> new ClosedRunningTimeInfoFormatter(runningTime);
			case BREAK_TIME -> new BreakTimeRunningTimeInfoFormatter(runningTime);
			case ONLY_ONLINE -> new OnlyOnlineRunningTimeInfoFormatter(runningTime);
		};
	}
}
