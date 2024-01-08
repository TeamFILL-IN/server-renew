package com.teamfillin.fillin.domain.user;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import lombok.AccessLevel;
import lombok.Builder;

public class User {
	private final long no;
	private final String nickname;
	private final String profileImagePath;
	private final UserStatus status;

	@Builder(access = AccessLevel.PRIVATE)
	private User(long no, String nickname, UserStatus status, String profileImagePath) {
		this.no = no;
		this.nickname = nickname;
		this.status = status;
		this.profileImagePath = profileImagePath;
	}

	public long getNo() {
		return no;
	}

	@NotNull
	public String getNickname() {
		return nickname;
	}

	@Nullable
	public String getProfileImagePath() {
		return profileImagePath;
	}

	@NotNull
	public UserStatus getStatus() {
		return status;
	}

	public static User from(@NotNull UserEntity userEntity) {
		return User.builder()
			.no(userEntity.getNo())
			.nickname(userEntity.getNickname())
			.status(userEntity.getStatus())
			.profileImagePath(userEntity.getProfileImagePath())
			.build();
	}

	@Override
	public int hashCode() {
		return Objects.hash(no, nickname, profileImagePath, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			User target = (User)obj;
			return no == target.no;
		}
		return false;
	}
}
