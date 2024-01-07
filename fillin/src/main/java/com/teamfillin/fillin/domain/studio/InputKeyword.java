package com.teamfillin.fillin.domain.studio;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InputKeyword {

	private static final String SPLITTER = " ";

	private final List<String> values;

	private InputKeyword(List<String> values) {
		this.values = values;
	}

	public static InputKeyword from(String keyword) {
		return new InputKeyword(Arrays.asList((keyword.split(SPLITTER))));
	}

	public List<String> getValues() {
		return values;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		InputKeyword that = (InputKeyword)o;
		return Objects.equals(values, that.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}
}
