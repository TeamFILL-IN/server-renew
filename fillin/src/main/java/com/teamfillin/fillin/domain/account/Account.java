package com.teamfillin.fillin.domain.user;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filiin_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Embedded
	private SocialInfo socialInfo;

	@Column(length = 500)
	private String refreshToken;

	@Column(nullable = false)
	private Long userNo;

	protected User() {
	}

	public User(Long no, SocialInfo socialInfo, String refreshToken, Long userNo) {
		this.no = no;
		this.socialInfo = socialInfo;
		this.refreshToken = refreshToken;
		this.userNo = userNo;
	}
}
