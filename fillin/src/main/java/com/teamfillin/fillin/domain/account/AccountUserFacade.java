package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teamfillin.fillin.domain.user.User;
import com.teamfillin.fillin.domain.user.UserRegister;
import com.teamfillin.fillin.domain.user.UserRetriever;

@Component
public class AccountUserFacade {
	private final AccountRegister accountRegister;
	private final AccountRetriever accountRetriever;
	private final UserRegister userRegister;
	private final UserRetriever userRetriever;

	public AccountUserFacade(
		AccountRegister accountRegister
		, AccountRetriever accountRetriever
		, UserRegister userRegister
		, UserRetriever userRetriever
	) {
		this.accountRegister = accountRegister;
		this.accountRetriever = accountRetriever;
		this.userRegister = userRegister;
		this.userRetriever = userRetriever;
	}

	@NotNull
	@Transactional(readOnly = true)
	public AccountAndUserResult retrieve(@NotNull SocialType socialType, @NotNull String idKey) {
		final Account foundAccount = accountRetriever.retrieve(socialType, idKey);
		final User foundUser = userRetriever.retrieve(foundAccount.getUserNo());

		return AccountAndUserResult.of(foundAccount, foundUser);
	}

	@Nullable
	@Transactional(readOnly = true)
	public AccountAndUserResult retrieveAccountAndUserOrNull(@NotNull SocialType socialType, @NotNull String idKey) {
		final Account foundAccount = accountRetriever.retrieveOrNull(socialType, idKey);

		if (foundAccount != null) {
			final User foundUser = userRetriever.retrieve(foundAccount.getUserNo());
			return AccountAndUserResult.of(foundAccount, foundUser);
		}

		return null;
	}

	@NotNull
	@Transactional
	public AccountAndUserResult registerAccountAndUser(@NotNull SocialType socialType, @NotNull String idKey)
		throws DataIntegrityViolationException {
		final User registeredUser = userRegister.registerUser();
		final Account registeredAccount = accountRegister.registerAccount(
			socialType,
			idKey,
			registeredUser.getNo()
		);

		return AccountAndUserResult.of(registeredAccount, registeredUser);
	}
}
