package com.teamfillin.fillin.domain.studio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InputKeywordCommand {

	private static final String SPLITTER = " ";

	private final List<String> values;

	private InputKeywordCommand(List<String> values) {
		this.values = values;
	}

	public static InputKeywordCommand from(String keyword) {
		if (keyword == null) {
			return new InputKeywordCommand(Collections.emptyList());
		}
		return new InputKeywordCommand(
			Arrays.stream(keyword.split(SPLITTER))
				.collect(Collectors.toList())
		);
	}

	public List<String> getOriginValues() {
		return new ArrayList<>(values);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InputKeywordCommand that = (InputKeywordCommand)o;
		return Objects.equals(values, that.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}
}
