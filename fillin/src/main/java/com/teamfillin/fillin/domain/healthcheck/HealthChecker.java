package com.teamfillin.fillin.domain.healthcheck;

import static com.teamfillin.fillin.domain.healthcheck.HealthCheckErrorCode.*;

import org.springframework.stereotype.Service;

import com.teamfillin.fillin.FillinException;

@Service
public class HealthChecker {
	public void succeed() {
	}

	public void forceFail() {
		throw FillinException.builder()
			.errorCode(E400_HEALTH_CHECK_BAD_REQUEST)
			.build();
	}
}
