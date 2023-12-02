package com.teamfillin.fillin.domain.runningTime;

public enum DayOfWeek {

	MON("월요일"),
	TUE("화요일"),
	WED("수요일"),
	THR("목요일"),
	FRI("금요일"),
	SAT("토요일"),
	SUN("일요일"),
	EVERY_DAY("매일"),
	WEEK_DAY("평일"),
	WEEK_END("주말"),
	;

	private final String value;

	DayOfWeek(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
