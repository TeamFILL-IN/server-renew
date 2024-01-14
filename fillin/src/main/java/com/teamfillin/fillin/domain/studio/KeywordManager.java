package com.teamfillin.fillin.domain.studio;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.jetbrains.annotations.NotNull;

class KeywordManager {

	private static final String BLANK = " ";
	private static final int TOKEN_SIZE = 2;
	private static final String CHUNK_SPLIT_REGEX = "(?<=\\G.{" + TOKEN_SIZE + "})";
	private static final String CRITICAL_OPERATOR = "+";

	private final Map<Value, List<String>> values;

	private KeywordManager(Map<Value, List<String>> values) {
		this.values = values;
	}

	String makeSearchKeyword() {
		return makeCriticalSearchKeyword() + makeMinorSearchKeyword();
	}

	private String makeCriticalSearchKeyword() {
		StringBuilder sb = new StringBuilder();
		for (String criticalKeyWord : getCriticalKeyWords()) {
			sb.append(CRITICAL_OPERATOR).append(criticalKeyWord).append(BLANK);
		}
		return sb.toString();
	}

	private List<String> getCriticalKeyWords() {
		return values.get(Value.CRITICAL);
	}

	private String makeMinorSearchKeyword() {
		StringBuilder sb = new StringBuilder();
		for (String minorKeyWord : getMinorKeyWords()) {
			sb.append(minorKeyWord).append(BLANK);
		}
		return sb.toString();
	}

	private List<String> getMinorKeyWords() {
		return values.get(Value.MINOR);
	}

	static KeywordManager from(InputKeywordCommand inputKeywordCommand) {
		Map<Value, List<String>> keywordsWithValue = new EnumMap<>(Value.class);
		List<String> inputKeywordTokens = inputKeywordCommand.getOriginValues();
		StopWord.removeStopWordIn(inputKeywordTokens);
		keywordsWithValue.put(Value.CRITICAL, refineKeywordsForSearch(inputKeywordTokens));
		keywordsWithValue.put(Value.MINOR, StopWord.replaceStopWordToModifiedWord(inputKeywordCommand.getOriginValues()));
		return new KeywordManager(keywordsWithValue);
	}

	@NotNull
	private static List<String> refineKeywordsForSearch(List<String> keywordTokens) {
		return keywordTokens.stream()
			.flatMap(token -> token.length() > TOKEN_SIZE
				? Arrays.stream(token.split(CHUNK_SPLIT_REGEX))
				: Stream.of(token))
			.filter(token -> token.length() == TOKEN_SIZE)
			.toList();
	}

	enum StopWord {

		HYEONSANG_SO("현상소", "현상"),
		STUDIO("스튜디오", "스튜"),
		SAJIIN_GWAN("사진관", "사진"),
		CAMERA("카메라", "카메"),
		FILM("필름", "필름"),
		PHOTO("포토", "포토"),
		;

		private final String origin;
		private final String modified;

		StopWord(String origin, String modified) {
			this.origin = origin;
			this.modified = modified;
		}

		static List<String> replaceStopWordToModifiedWord(List<String> keywordTokens) {
			return Arrays.stream(values())
				.filter(stopWord ->
					keywordTokens.stream().anyMatch(token ->
						token.contains(stopWord.origin) || token.contains(stopWord.modified))
				)
				.map(stopWord -> stopWord.modified)
				.toList();
		}

		static void removeStopWordIn(List<String> keywordTokens) {
			Arrays.stream(values())
				.forEach(stopWord ->
					keywordTokens.removeIf(token ->
						token.contains(stopWord.origin) || token.contains(stopWord.modified)
				));
		}
	}

	enum Value {
		CRITICAL, MINOR;
	}
}
