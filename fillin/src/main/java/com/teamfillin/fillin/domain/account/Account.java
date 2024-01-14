package com.teamfillin.fillin.domain.account;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.Builder;

public class Account {
	private final long no;
	private final String refreshToken;
	private final long userNo;
	private final String socialId;
	private final SocialType socialType;

	@Builder
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

	@Override
	public int hashCode() {
		return Objects.hash(no, userNo, socialId, socialType);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Account target = (Account)obj;
			return no == target.no;
		}
		return false;
	}
}
