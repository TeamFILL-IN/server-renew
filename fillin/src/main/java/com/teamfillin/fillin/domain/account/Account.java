package com.teamfillin.fillin.domain.account;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Embedded
	private SocialInfo socialInfo;

	@Column(length = 500)
	private String refreshToken;

	@Column(nullable = false, unique = true)
	private Long userNo;

	protected Account() {
	}

	public Account(SocialInfo socialInfo, String refreshToken, Long userNo) {
		this.socialInfo = socialInfo;
		this.refreshToken = refreshToken;
		this.userNo = userNo;
	}
}
