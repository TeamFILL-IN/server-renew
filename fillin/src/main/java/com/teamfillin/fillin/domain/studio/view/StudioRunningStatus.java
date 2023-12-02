package com.teamfillin.fillin.domain.studio.view;

enum StudioRunningStatus {

	OPEN("운영중"),
	CLOSED("영업 종료"),
	BREAK_TIME("브레이크 타임"),
	;

	private final String value;

	StudioRunningStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
