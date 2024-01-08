package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.teamfillin.fillin.domain.account.AccountEntity.SocialInfo;

@Component
public class AccountRegister {
	private final AccountRepository accountRepository;

	public AccountRegister(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	// TODO : 중복 요청으로 인한 unique error catch 필요
	@Transactional(propagation = Propagation.MANDATORY)
	public Account registerAccount(
		@NotNull SocialType socialType,
		@NotNull String socialId,
		long userNo
	) {
		final SocialInfo socialInfo = SocialInfo.from(socialType, socialId);
		final AccountEntity registeredAccountEntity = accountRepository.save(AccountEntity.from(socialInfo, userNo));

		return Account.from(registeredAccountEntity);
	}
}
