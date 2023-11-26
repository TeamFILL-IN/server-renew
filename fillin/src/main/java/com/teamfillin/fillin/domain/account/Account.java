package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.AccessLevel;
import lombok.Builder;

public class Account {
	private final long no;
	private final String refreshToken;
	private final long userNo;
	private final String socialId;
	private final SocialType socialType;

	@Builder(access = AccessLevel.PRIVATE)
	private Account(long no, String refreshToken, long userNo, String socialId, SocialType socialType) {
		this.no = no;
		this.refreshToken = refreshToken;
		this.userNo = userNo;
		this.socialId = socialId;
		this.socialType = socialType;
	}

	public long getNo() {
		return no;
	}

	@Nullable
	public String getRefreshToken() {
		return refreshToken;
	}

	@NotNull
	public long getUserNo() {
		return userNo;
	}

	@NotNull
	public String getSocialId() {
		return socialId;
	}

	@NotNull
	public SocialType getSocialType() {
		return socialType;
	}

	public static Account from(@NotNull AccountEntity accountEntity) {
		return Account.builder()
			.no(accountEntity.getNo())
			.userNo(accountEntity.getUserNo())
			.socialType(accountEntity.getSocialInfo().getSocialType())
			.socialId(accountEntity.getSocialInfo().getSocialId())
			.refreshToken(accountEntity.getRefreshToken())
			.build();
	}

	@NotNull
	public AccountEntity.SocialInfo getSocialInfo() {
		return AccountEntity.SocialInfo.from(socialType, socialId);
	}
}
