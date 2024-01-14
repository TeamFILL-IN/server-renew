package com.teamfillin.fillin.domain.studio;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputKeywordTest {

	@DisplayName("InputKeyword 생성시 문자열을 공백 기준 개별 키워드로 분할한다")
	@Test
	void from() {
		// given
		String input = "필린 현상소";

		// when
		InputKeyword actual = InputKeyword.from(input);

		// then
		List<String> expected = List.of("필린", "현상소");
		assertThat(actual.getOriginValues()).containsAll(expected);
	}

	@DisplayName("InputKeyword 생성시 null 이 들어오면 empty list 를 반환한다")
	@Test
	void fromNull() {
		// given, when
		InputKeyword actual = InputKeyword.from(null);

		// then
		assertThat(actual.getOriginValues()).isEmpty();
	}

	@DisplayName("getOriginValues 로 가져온 값은 외부에서 변경해도 내부는 변경되지 않는다")
	@Test
	void getOriginValues() {
		// given
		String input = "필린 현상소";
		InputKeyword inputKeyword = InputKeyword.from(input);

		// when
		List<String> expected = List.of("필린", "현상소");
		inputKeyword.getOriginValues().removeAll(expected);

		// then
		assertThat(inputKeyword.getOriginValues()).containsAll(expected);
	}
}
