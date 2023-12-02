package com.teamfillin.fillin.domain.studio;

import java.time.Clock;
import java.time.ZoneId;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeConfiguration {

	private static final ZoneId KOREA_TIME_ZONE = ZoneId.of("Asia/Seoul");

	@Bean
	public Clock koreaTimeClock() {
		return Clock.system(KOREA_TIME_ZONE);
	}
}
