package com.teamfillin.fillin.domain.runningTime;

import java.time.LocalTime;

public class RunningTime {

	private final long studioNo;
	private final DayOfWeek dayOfWeek;
	private final OperationStatus operationStatus;
	private final LocalTime startAt;
	private final LocalTime endAt;

	public RunningTime(long studioNo, DayOfWeek dayOfWeek, OperationStatus operationStatus, LocalTime startAt,
		LocalTime endAt) {
		this.studioNo = studioNo;
		this.dayOfWeek = dayOfWeek;
		this.operationStatus = operationStatus;
		this.startAt = startAt;
		this.endAt = endAt;
	}

	public boolean isBetween(LocalTime now) {
		return startAt.isBefore(now) && endAt.isAfter(now);
	}

	public String getDayOfWeek() {
		return dayOfWeek.getValue();
	}

	public OperationStatus getOperationStatus() {
		return operationStatus;
	}

	public LocalTime getStartAt() {
		return startAt;
	}

	public LocalTime getEndAt() {
		return endAt;
	}
}
