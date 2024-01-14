package com.teamfillin.fillin.domain.studio;

import com.teamfillin.fillin.FillinException;

class StudioExceptionHandler {

	private StudioExceptionHandler() {
	}

	public static FillinException notFound() {
		throw FillinException.from(StudioErrorCode.E404_STUDIO_NOT_FOUND);
	}
}
