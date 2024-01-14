package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teamfillin.fillin.domain.user.User;

@Component
public class AccountUserFacade {
	private final AccountRegister accountRegister;
	private final AccountRetriever accountRetriever;
	private final UserBridge userBridge;

	public AccountUserFacade(
		AccountRegister accountRegister
		, AccountRetriever accountRetriever
		, UserBridge userBridge
	) {
		this.accountRegister = accountRegister;
		this.accountRetriever = accountRetriever;
		this.userBridge = userBridge;
	}

	@NotNull
	@Transactional(readOnly = true)
	public AccountAndUser retrieve(@NotNull SocialType socialType, @NotNull String idKey) {
		final Account foundAccount = accountRetriever.retrieve(socialType, idKey);
		final User foundUser = userBridge.retrieveUser(foundAccount.getUserNo());

		return new AccountAndUser(foundAccount, foundUser);
	}

	@Nullable
	@Transactional(readOnly = true)
	public AccountAndUser retrieveOrNull(@NotNull SocialType socialType, @NotNull String idKey) {
		final Account foundAccount = accountRetriever.retrieveOrNull(socialType, idKey);

		if (foundAccount != null) {
			final User foundUser = userBridge.retrieveUser(foundAccount.getUserNo());
			return new AccountAndUser(foundAccount, foundUser);
		}

		return null;
	}

	@NotNull
	@Transactional
	public AccountAndUser registerAccountAndUser(@NotNull SocialType socialType, @NotNull String idKey)
		throws DataIntegrityViolationException {
		final User registeredUser = userBridge.registerUser();
		final Account registeredAccount = accountRegister.registerAccount(
			socialType,
			idKey,
			registeredUser.getNo()
		);

		return new AccountAndUser(registeredAccount, registeredUser);
	}
}
