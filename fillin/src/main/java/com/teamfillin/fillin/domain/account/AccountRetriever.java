package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

@Component
public class AccountRetriever {
	private final AccountRepository accountRepository;

	public AccountRetriever(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@NotNull
	public Account retrieve(@NotNull SocialType socialType, @NotNull String socialId) {
		return accountRepository.findAccountBySocialInfo(AccountEntity.SocialInfo.from(socialType, socialId))
			.map(Account::from)
			.orElseThrow();
	}

	@Nullable
	public Account retrieveOrNull(@NotNull SocialType socialType, @NotNull String socialId) {
		return accountRepository.findAccountBySocialInfo(AccountEntity.SocialInfo.from(socialType, socialId))
			.map(Account::from)
			.orElse(null);
	}
}
