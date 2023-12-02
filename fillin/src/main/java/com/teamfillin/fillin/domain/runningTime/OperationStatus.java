package com.teamfillin.fillin.domain.runningTime;

public enum BusinessStatus {

	OPEN("운영"),
	CLOSED("휴무"),
	BREAK_TIME("브레이크 타임"),
	ONLY_ONLINE("온라인만 운영"),
	;

	private final String value;

	BusinessStatus(String value) {
		this.value = value;
	}
}
