package com.teamfillin.fillin.api.studio;

import com.teamfillin.fillin.domain.studio.InputKeywordCommand;

public class InputKeywordRequest {

	private String keyword;

	private InputKeywordRequest() {
	}

	public InputKeywordRequest(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	public InputKeywordCommand toInputKeywordCommand() {
		return InputKeywordCommand.from(keyword);
	}
}
