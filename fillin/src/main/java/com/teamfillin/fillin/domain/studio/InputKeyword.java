package com.teamfillin.fillin.api.studio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputKeyword {

	private static final String SPLITTER = " ";

	private final String value;

	public InputKeyword(String value) {
		this.value = value;
	}

	public List<String> getInputKeywordTokens() {
		return Arrays.stream(value.split(SPLITTER))
			.collect(Collectors.toList());
	}
}
