package com.teamfillin.fillin.domain.runningTime;

public enum OperationStatus {

	OPEN("운영"),
	CLOSED("휴무"),
	BREAK_TIME("브레이크 타임"),
	ONLY_ONLINE("온라인만 운영"),
	;

	private final String value;

	OperationStatus(String value) {
		this.value = value;
	}

	public boolean isBreakTime() {
		return this == BREAK_TIME;
	}

	public boolean isClosed() {
		return this == CLOSED;
	}

	public String getValue() {
		return value;
	}
}
