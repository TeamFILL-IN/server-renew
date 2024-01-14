package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.teamfillin.fillin.domain.account.AccountEntity.SocialInfo;

@Component
public class AccountRegister {
	private final AccountRepository accountRepository;

	public AccountRegister(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Transactional
	public Account registerAccount(
		@NotNull SocialType socialType,
		@NotNull String socialId,
		long userNo
	) throws DataIntegrityViolationException {
		final SocialInfo socialInfo = SocialInfo.from(socialType, socialId);
		final AccountEntity registeredAccountEntity = accountRepository.save(AccountEntity.from(socialInfo, userNo));

		return Account.builder()
			.no(registeredAccountEntity.getNo())
			.userNo(registeredAccountEntity.getUserNo())
			.socialType(registeredAccountEntity.getSocialInfo().getSocialType())
			.socialId(registeredAccountEntity.getSocialInfo().getSocialId())
			.refreshToken(registeredAccountEntity.getRefreshToken())
			.build();
	}
}
