package com.teamfillin.fillin.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fillin_user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false)
	private String nickname;

	@Column(length = 500)
	private String profileImagePath;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private UserStatus status;

	protected UserEntity() {
	}

	public UserEntity(String nickname, String profileImagePath) {
		this.nickname = nickname;
		this.profileImagePath = profileImagePath;
		this.status = UserStatus.ACTIVE;
	}
}
