package com.teamfillin.fillin.domain.studio;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class KeywordManagerTest {

	@DisplayName("입력 키워드를 검색용 키워드로 변환한다")
	@ParameterizedTest
	@MethodSource("provideInputKeywordAndSearchKeywordExpected")
	void makeSearchKeyword(String input, String expected) {
		// given
		InputKeywordCommand inputKeywordCommand = InputKeywordCommand.from(input);
		KeywordManager keywordManager = KeywordManager.from(inputKeywordCommand);

		// when
		String actual = keywordManager.makeSearchKeyword();

		// then
		assertThat(actual).isEqualTo(expected);
	}

	private static Stream<Arguments> provideInputKeywordAndSearchKeywordExpected() {
		return Stream.of(
			Arguments.of("분당 대왕판교로 현상소", "+분당 +대왕 +판교 현상 "),
			Arguments.of("논현동 황제 스튜디오", "+논현 +황제 스튜 "),
			Arguments.of("부산광역시 간지 사진관", "+부산 +광역 +간지 사진 "),
			Arguments.of("압구정 카메라", "+압구 카메 "),
			Arguments.of("대구 중구 동성로 필름", "+대구 +중구 +동성 필름 "),
			Arguments.of("인천 포토", "+인천 포토 ")
		);
	}

	@DisplayName("입력 검색어 토큰에 StopWord 가 포함되어 있으면 수정된 StopWord 를 반환하고, 포함되어 있지 않다면 빈 리스트를 반환한다")
	@ParameterizedTest
	@MethodSource("provideTokensAndModifyExpected")
	void replaceStopWordToModifiedWord(List<String> tokens, List<String> expected) {
	    // given
		List<String> keywordTokens = new ArrayList<>(tokens);

		// when
		List<String> actual = KeywordManager.StopWord.replaceStopWordToModifiedWord(keywordTokens);

		// then
		assertThat(actual).containsAll(expected);
	}

	private static Stream<Arguments> provideTokensAndModifyExpected() {
		return Stream.of(
			Arguments.of(List.of("분당", "대왕판교로현상소"), List.of("현상")),
			Arguments.of(List.of("논현동", "황제", "스튜디오"), List.of("스튜")),
			Arguments.of(List.of("부산광역시", "간지", "사진관"), List.of("사진")),
			Arguments.of(List.of("압구정", "카메라"), List.of("카메")),
			Arguments.of(List.of("대구", "중구", "동성로", "필름"), List.of("필름")),
			Arguments.of(List.of("인천", "포토"), List.of("포토")),
			Arguments.of(List.of("STOP", "WORD", "미포함"), Collections.emptyList())
		);
	}

	@DisplayName("입력 검색어 토큰에 StopWord 가 포함되어 있으면 헤당 토큰을 삭제하고, 포함되어 있지 않다면 삭제하지 않는다")
	@ParameterizedTest
	@MethodSource("provideTokensAndRemoveExpected")
	void removeStopWordIn(List<String> tokens, List<String> expected) {
	    // given
		List<String> keywordTokens = new ArrayList<>(tokens);

		// when
		KeywordManager.StopWord.removeStopWordIn(keywordTokens);

	    // then
		assertThat(keywordTokens).containsAll(expected);
	}

	private static Stream<Arguments> provideTokensAndRemoveExpected() {
		return Stream.of(
			Arguments.of(List.of("분당", "대왕판교로", "현상소"), List.of("분당", "대왕판교로")),
			Arguments.of(List.of("논현동", "황제", "스튜디오"), List.of("논현동", "황제")),
			Arguments.of(List.of("부산광역시", "간지", "사진관"), List.of("부산광역시", "간지")),
			Arguments.of(List.of("압구정", "카메라"), List.of("압구정")),
			Arguments.of(List.of("대구", "중구", "동성로", "필름"), List.of("대구", "중구", "동성로")),
			Arguments.of(List.of("인천", "포토"), List.of("인천")),
			Arguments.of(List.of("STOP", "WORD", "미포함"), List.of("STOP", "WORD", "미포함"))
		);
	}
}
