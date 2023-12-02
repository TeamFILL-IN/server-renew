package com.teamfillin.fillin.domain.studio.view;

import java.util.List;
import java.util.StringJoiner;

import com.teamfillin.fillin.domain.runningTime.OperationStatus;
import com.teamfillin.fillin.domain.runningTime.RunningTime;

public class RunningTimeView {

	private static final String SPACE = " ";
	private static final String DASH = " - ";
	private static final String LINE_BREAK = "\n";

	private final List<RunningTime> values;

	public RunningTimeView(List<RunningTime> values) {
		this.values = values;
	}

	public String getRunningTimeInfo() {
		if (values.isEmpty()) {
			return null;
		}
		StringJoiner sj = new StringJoiner(LINE_BREAK);
		for (RunningTime value : values) {
			RunningTimeInfoFormatter runningTimeInfoFormatter = RunningTimeInfoFormatterFactory.getBy(value);
			sj.add(runningTimeInfoFormatter.format());

			OperationStatus operationStatus = value.getOperationStatus();
			String runningTimeInfo;
			if (operationStatus.isClosed()) {
				runningTimeInfo = value.getDayOfWeek() + SPACE + operationStatus.getValue();
			} else if (operationStatus.isBreakTime()) {
				runningTimeInfo = operationStatus.getValue() + SPACE + value.getStartAt() + DASH + value.getEndAt();
			} else if (operationStatus.isOnlyOnline()) {
				runningTimeInfo = operationStatus.getValue();
			} else {
				runningTimeInfo = value.getDayOfWeek() + SPACE + value.getStartAt() + DASH + value.getEndAt();
			}
			sj.add(runningTimeInfo);
		}
		return sj.toString();
	}
}
