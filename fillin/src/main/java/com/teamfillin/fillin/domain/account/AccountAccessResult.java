package com.teamfillin.fillin.domain.account;

import org.jetbrains.annotations.NotNull;

import lombok.AccessLevel;
import lombok.Builder;

public class AccountAccessResult {
	private final PROCEDURE procedure;
	private final long accountNo;
	private final long userNo;
	private final SocialType socialType;
	private final String nickname;

	@Builder(access = AccessLevel.PRIVATE)
	private AccountAccessResult(PROCEDURE procedure, SocialType socialType, String nickname, long accountNo, long userNo
	) {
		this.procedure = procedure;
		this.socialType = socialType;
		this.nickname = nickname;
		this.accountNo = accountNo;
		this.userNo = userNo;
	}

	public static AccountAccessResult login(@NotNull AccountAndUserResult accountAndUserResult) {
		return AccountAccessResult.builder()
			.procedure(PROCEDURE.LOGIN)
			.socialType(accountAndUserResult.getSocialType())
			.nickname(accountAndUserResult.getNickname())
			.accountNo(accountAndUserResult.getAccountNo())
			.userNo(accountAndUserResult.getUserNo())
			.build();
	}

	public static AccountAccessResult join(@NotNull AccountAndUserResult accountAndUserResult) {
		return AccountAccessResult.builder()
			.procedure(PROCEDURE.JOIN)
			.socialType(accountAndUserResult.getSocialType())
			.nickname(accountAndUserResult.getNickname())
			.accountNo(accountAndUserResult.getAccountNo())
			.userNo(accountAndUserResult.getUserNo())
			.build();
	}

	@NotNull
	public SocialType getSocialType() {
		return socialType;
	}

	@NotNull
	public String getNickname() {
		return nickname;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public long getUserNo() {
		return userNo;
	}

	public PROCEDURE getProcedure() {
		return procedure;
	}

	public enum PROCEDURE {
		LOGIN,
		JOIN,
	}
}
