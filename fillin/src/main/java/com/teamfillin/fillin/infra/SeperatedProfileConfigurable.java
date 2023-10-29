package com.teamfillin.fillin.infra;

import javax.transaction.NotSupportedException;

import org.springframework.context.annotation.Profile;

public interface SeperatedProfileConfigurable<PRODUCT> {
	@Profile({"test", "local"})
	PRODUCT embedded();

	@Profile({"dev", "prod"})
	PRODUCT remote() throws NotSupportedException;
}
