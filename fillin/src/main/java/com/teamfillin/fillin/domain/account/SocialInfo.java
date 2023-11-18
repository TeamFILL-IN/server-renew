package com.teamfillin.fillin.domain.user;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class SocialInfo {

	@Column(nullable = false, length = 100)
	private String socialId;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false, length = 10)
	private SocialType socialType;

	protected SocialInfo() {
	}

	public SocialInfo(String socialId, SocialType socialType) {
		this.socialId = socialId;
		this.socialType = socialType;
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
}
