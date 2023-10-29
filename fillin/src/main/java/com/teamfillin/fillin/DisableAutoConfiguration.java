package com.teamfillin.fillin;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * 일부 의존에 대해 spring boot 자동 구성을 해제한다.
 * - 자유로운 설정을 위해
 */
@Configuration
@EnableAutoConfiguration(
	exclude = {
		// jdbc datasource
		DataSourceAutoConfiguration.class,
	}
)
public class DisableAutoConfiguration {
}
