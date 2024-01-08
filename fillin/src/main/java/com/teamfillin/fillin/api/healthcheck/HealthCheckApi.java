package com.teamfillin.fillin.api.healthcheck;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfillin.fillin.api.FillinApiResponse;
import com.teamfillin.fillin.domain.healthcheck.HealthChecker;

@RestController
public class HealthCheckApi {
	private final HealthChecker healthChecker;

	public HealthCheckApi(HealthChecker healthChecker) {
		this.healthChecker = healthChecker;
	}

	@GetMapping("/health/readiness")
	public ResponseEntity<FillinApiResponse> readiness() {
		healthChecker.succeed();
		return FillinApiResponse.success();
	}

	@GetMapping("/health/exception")
	public void exception() {
		healthChecker.forceFail();
	}
}
