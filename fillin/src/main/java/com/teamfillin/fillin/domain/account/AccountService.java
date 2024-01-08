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
	public AccountAccessResult loginOrJoin(@NotNull SocialType socialType, @NotNull String idKey) {
		final AccountAndUserResult accountAndUser = accountUserFacade.retrieveAccountAndUserOrNull(socialType, idKey);
		if (joined(accountAndUser)) {
			return AccountAccessResult.login(accountAndUser);
		}

		final AccountAndUserResult joinResult;
		try {
			joinResult = accountUserFacade.registerAccountAndUser(socialType, idKey);
		} catch (DataIntegrityViolationException e) { // unique error 에 대한 catch
			final AccountAndUserResult foundAccountAndUser = accountUserFacade.retrieve(socialType, idKey);
			return AccountAccessResult.login(foundAccountAndUser);
		}
		return AccountAccessResult.join(joinResult);
	}

	private boolean joined(AccountAndUserResult accountAndUser) {
		return accountAndUser != null;
	}
}
