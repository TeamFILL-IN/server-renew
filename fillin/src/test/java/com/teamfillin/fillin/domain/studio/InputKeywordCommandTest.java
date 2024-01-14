package com.teamfillin.fillin.domain.studio;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputKeywordCommandTest {

	@DisplayName("InputKeyword 생성시 문자열을 공백 기준 개별 키워드로 분할한다")
	@Test
	void from() {
		// given
		String input = "필린 현상소";

		// when
		InputKeywordCommand actual = InputKeywordCommand.from(input);

		// then
		List<String> expected = List.of("필린", "현상소");
		assertThat(actual.getOriginValues()).containsAll(expected);
	}

	@DisplayName("InputKeyword 생성시 null 이 들어오면 empty list 를 반환한다")
	@Test
	void fromNull() {
		// given, when
		InputKeywordCommand actual = InputKeywordCommand.from(null);

		// then
		assertThat(actual.getOriginValues()).isEmpty();
	}

	@DisplayName("getOriginValues 로 가져온 값은 외부에서 변경해도 내부는 변경되지 않는다")
	@Test
	void getOriginValues() {
		// given
		String input = "필린 현상소";
		InputKeywordCommand inputKeywordCommand = InputKeywordCommand.from(input);

		// when
		List<String> expected = List.of("필린", "현상소");
		inputKeywordCommand.getOriginValues().removeAll(expected);

		// then
		assertThat(inputKeywordCommand.getOriginValues()).containsAll(expected);
	}
}
