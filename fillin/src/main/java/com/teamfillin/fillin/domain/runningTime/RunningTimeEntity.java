package com.teamfillin.fillin.domain.runningTime;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "running_time")
public class RunningTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false)
	private Long studioNo;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private DayOfWeek dayOfWeek;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OperationStatus operationStatus;

	private LocalDateTime startAt;

	private LocalDateTime endAt;

	protected RunningTimeEntity() {
	}

	public RunningTime toRunningTime() {
		return new RunningTime(
			studioNo,
			dayOfWeek,
			operationStatus,
			startAt.toLocalTime(),
			endAt.toLocalTime()
		);
	}

	public Long getStudioNo() {
		return studioNo;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public OperationStatus getOperationStatus() {
		return operationStatus;
	}

	public LocalDateTime getStartAt() {
		return startAt;
	}

	public LocalDateTime getEndAt() {
		return endAt;
	}
}
