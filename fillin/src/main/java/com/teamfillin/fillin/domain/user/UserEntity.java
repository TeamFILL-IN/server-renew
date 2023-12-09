package com.teamfillin.fillin.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;

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

	private UserEntity(@NotNull String nickname, @NotNull UserStatus userStatus, @NotNull String profileImagePath) {
		this.nickname = nickname;
		this.status = userStatus;
		this.profileImagePath = profileImagePath;
	}

	private UserEntity(@NotNull String nickname, @NotNull UserStatus userStatus) {
		this.nickname = nickname;
		this.status = userStatus;
	}

	public static UserEntity createActive(@NotNull String nickname) {
		return new UserEntity(nickname, UserStatus.ACTIVE);
	}

	public Long getNo() {
		return no;
	}

	public String getNickname() {
		return nickname;
	}

	public String getProfileImagePath() {
		return profileImagePath;
	}

	public UserStatus getStatus() {
		return status;
	}
}
