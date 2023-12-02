package com.teamfillin.fillin.domain.runningTime.view;

import java.time.LocalTime;
import java.util.List;
import java.util.StringJoiner;

import javax.annotation.Nullable;

import com.teamfillin.fillin.domain.runningTime.OperationStatus;
import com.teamfillin.fillin.domain.runningTime.RunningTime;

public class RunningTimeView {

	private static final String LINE_BREAK = "\n";

	private final List<RunningTime> values;

	public RunningTimeView(List<RunningTime> values) {
		this.values = values;
	}

	/**
	 * 기존 time 이 TEXT 로 들어가 있었기 때문에 응답 형식이 너무 자유로움.
	 * 어느정도 틀을 잡아둘 필요 있음
	 * @return issue 첨부 파일 참조
	 */
	@Nullable
	public String getRunningTimeInfo() {
		if (values.isEmpty()) {
			return null;
		}
		StringJoiner sj = new StringJoiner(LINE_BREAK);
		for (RunningTime value : values) {
			RunningTimeInfoFormatter runningTimeInfoFormatter = RunningTimeInfoFormatterFactory.getBy(value);
			sj.add(runningTimeInfoFormatter.format());
		}
		return sj.toString();
	}

	public OperationStatus getCurrentOperationStatus(LocalTime now) {
		return values.stream()
			.filter(runningTime -> runningTime.isBetween(now))
			.map(RunningTime::getOperationStatus)
			.findFirst()
			.orElse(OperationStatus.CLOSED);
	}
}
