package com.teamfillin.fillin.domain.runningTime.view;

import static com.teamfillin.fillin.domain.runningTime.DayOfWeek.*;
import static com.teamfillin.fillin.domain.runningTime.OperationStatus.*;
import static java.time.LocalTime.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.teamfillin.fillin.domain.runningTime.RunningTime;

class RunningTimeInfoFormatterTest {

	@DisplayName("RunningTime 의 OPEN, CLOSED, BREAK_TIME, ONLY_ONLINE 여부에 따른 운영 정보 형식을 반환한다")
	@ParameterizedTest
	@MethodSource("provideRunningTimeAndExpected")
	void format(RunningTime runningTime, String expected) {
		// given
		RunningTimeInfoFormatter formatter = RunningTimeInfoFormatterFactory.getBy(runningTime);

		// when
		String actual = formatter.format();

		// then
		assertThat(actual).isEqualTo(expected);
	}

	private static Stream<Arguments> provideRunningTimeAndExpected() {
		return Stream.of(
			Arguments.of(new RunningTime(1, WEEK_DAY, OPEN, NOON, MIDNIGHT), "평일 12:00 - 00:00"),
			Arguments.of(new RunningTime(2, WEEK_DAY, CLOSED, NOON, MIDNIGHT), "평일 휴무"),
			Arguments.of(new RunningTime(3, WEEK_DAY, BREAK_TIME, NOON, MIDNIGHT), "브레이크 타임 12:00 - 00:00"),
			Arguments.of(new RunningTime(4, WEEK_DAY, ONLY_ONLINE, NOON, MIDNIGHT), "온라인만 운영")
		);
	}
}
