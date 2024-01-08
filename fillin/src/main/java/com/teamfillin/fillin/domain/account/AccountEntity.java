package com.teamfillin.fillin.domain.account;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(
	name = "account",
	indexes = {
		@Index(name = "ux_account_social_info", columnList = "socialType, socialId")
	}
)
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Embedded
	private SocialInfo socialInfo;

	@Column(length = 500)
	private String refreshToken;

	@Column(nullable = false)
	private Long userNo;

	protected AccountEntity() {
	}

	private AccountEntity(@NotNull SocialInfo socialInfo, long userNo, @NotNull String refreshToken) {
		this.socialInfo = socialInfo;
		this.userNo = userNo;
		this.refreshToken = refreshToken;
	}

	private AccountEntity(@NotNull SocialInfo socialInfo, long userNo) {
		this.socialInfo = socialInfo;
		this.userNo = userNo;
	}

	public static AccountEntity from(@NotNull SocialInfo socialInfo, long userNo) {
		return new AccountEntity(socialInfo, userNo);
	}

	public Long getNo() {
		return no;
	}

	@NotNull
	public SocialInfo getSocialInfo() {
		return socialInfo;
	}

	@Nullable
	public String getRefreshToken() {
		return refreshToken;
	}

	public Long getUserNo() {
		return userNo;
	}

	@Embeddable
	public static class SocialInfo {

		@Column(nullable = false, length = 100)
		private String socialId;

		@Enumerated(value = EnumType.STRING)
		@Column(nullable = false, length = 10)
		private SocialType socialType;

		protected SocialInfo() {
		}

		private SocialInfo(String socialId, SocialType socialType) {
			this.socialId = socialId;
			this.socialType = socialType;
		}

		public static SocialInfo from(@NotNull SocialType socialType, @NotNull String socialId) {
			return new SocialInfo(socialId, socialType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			SocialInfo that = (SocialInfo)o;
			return Objects.equals(socialId, that.socialId) && socialType == that.socialType;
		}

		@Override
		public int hashCode() {
			return Objects.hash(socialId, socialType);
		}

		@NotNull
		public String getSocialId() {
			return socialId;
		}

		@NotNull
		public SocialType getSocialType() {
			return socialType;
		}
	}

}
