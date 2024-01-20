package com.teamfillin.fillin.domain.account;

import com.teamfillin.fillin.FillinException;

class AccountExceptionHandler {
	public static FillinException notFound() {
		throw FillinException.from(AccountErrorCode.E404_ACCOUNT_NOT_FOUND);
	}
}
