package com.teamfillin.fillin.domain.user;

import com.teamfillin.fillin.FillinException;

class UserExceptionHandler {
	public static FillinException notFound() {
		throw FillinException.from(UserErrorCode.E404_USER_NOT_FOUND);
	}
}
