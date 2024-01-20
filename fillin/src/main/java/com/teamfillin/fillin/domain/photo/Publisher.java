package com.teamfillin.fillin.domain.photo;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.teamfillin.fillin.domain.user.UserEntity;
import com.teamfillin.fillin.resource.Image;

public class Publisher {
	private final long userNo;
	private final String nickname;
	private final Image profileImage;

	private Publisher(long userNo, @NotNull String nickname, @Nullable Image profileImage) {
		this.userNo = userNo;
		this.nickname = nickname;
		this.profileImage = profileImage;
	}

	public static Publisher of(@NotNull UserEntity user, @NotNull Image profileImage) {
		return new Publisher(user.getNo(), user.getNickname(), profileImage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userNo, nickname, profileImage);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Publisher target = (Publisher)obj;
			return userNo == target.userNo
				&& Objects.equals(nickname, target.nickname)
				&& Objects.equals(profileImage, target.profileImage);
		}
		return false;
	}
}
