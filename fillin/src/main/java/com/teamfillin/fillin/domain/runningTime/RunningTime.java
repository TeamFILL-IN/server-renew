package com.teamfillin.fillin.domain.runningTime;

import java.time.LocalTime;

public class RunningTime {

	private final long studioNo;
	private final String dayOfWeek;
	private final OperationStatus operationStatus;
	private final LocalTime startAt;
	private final LocalTime endAt;

	public RunningTime(long studioNo, String dayOfWeek, OperationStatus operationStatus, LocalTime startAt,
		LocalTime endAt) {
		this.studioNo = studioNo;
		this.dayOfWeek = dayOfWeek;
		this.operationStatus = operationStatus;
		this.startAt = startAt;
		this.endAt = endAt;
	}

	public static RunningTime from(RunningTimeEntity runningTimeEntity) {
		return new RunningTime(
			runningTimeEntity.getStudioNo(),
			runningTimeEntity.getDayOfWeek().getValue(),
			runningTimeEntity.getOperationStatus(),
			runningTimeEntity.getStartAt().toLocalTime(),
			runningTimeEntity.getEndAt().toLocalTime()
		);
	}

	public boolean isBetween(LocalTime now) {
		return startAt.isBefore(now) && endAt.isAfter(now);
	}

	public String getDayOfWeek() {
		return dayOfWeek;
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
