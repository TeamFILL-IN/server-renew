package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
	private final AccountUserFacade accountUserFacade;

	public AccountService(AccountUserFacade accountUserFacade) {
		this.accountUserFacade = accountUserFacade;
	}

	@Transactional
	public AccountAccessResult loginOrJoin(@NotNull AccountCreateCommand command) {
		final SocialType socialType = command.getSocialType();
		final String idKey = command.getIdKey();

		final AccountAndUser accountAndUser = accountUserFacade.retrieveOrNull(socialType, idKey);
		if (joined(accountAndUser)) {
			return AccountAccessResult.login(accountAndUser);
		}

		final AccountAndUser joinResult;
		try {
			joinResult = accountUserFacade.registerAccountAndUser(socialType, idKey);
		} catch (DataIntegrityViolationException e) { // unique error 에 대한 catch
			final AccountAndUser foundAccountAndUser = accountUserFacade.retrieve(socialType, idKey);
			return AccountAccessResult.login(foundAccountAndUser);
		}
		return AccountAccessResult.join(joinResult);
	}

	private boolean joined(AccountAndUser accountAndUser) {
		return accountAndUser != null;
	}
}
