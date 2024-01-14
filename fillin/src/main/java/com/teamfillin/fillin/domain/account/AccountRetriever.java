package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountRetriever {
	private final AccountRepository accountRepository;

	public AccountRetriever(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@NotNull
	@Transactional(readOnly = true)
	public Account retrieve(@NotNull SocialType socialType, @NotNull String socialId) {
		return accountRepository.findAccountBySocialInfo(AccountEntity.SocialInfo.from(socialType, socialId))
			.map(this::toAccount)
			.orElseThrow(AccountExceptionHandler::notFound);
	}

	@Nullable
	public Account retrieveOrNull(@NotNull SocialType socialType, @NotNull String socialId) {
		return accountRepository.findAccountBySocialInfo(AccountEntity.SocialInfo.from(socialType, socialId))
			.map(this::toAccount)
			.orElse(null);
	}

	private Account toAccount(@NotNull final AccountEntity accountEntity) {
		return Account.builder()
			.no(accountEntity.getNo())
			.userNo(accountEntity.getUserNo())
			.socialId(accountEntity.getSocialInfo().getSocialId())
			.socialType(accountEntity.getSocialInfo().getSocialType())
			.refreshToken(accountEntity.getRefreshToken())
			.build();
	}
}
