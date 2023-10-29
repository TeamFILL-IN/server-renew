package com.teamfillin.fillin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.teamfillin.fillin.infra.datasource.DataSourceConfiguration;

@Configuration
@Import({
	DisableAutoConfiguration.class,
	DataSourceConfiguration.class
})
public class CoreConfiguration {
	public static Map<String, Object> getProperties() {
		Map<String, Object> additionalProperties = new ConcurrentHashMap<>();

		additionalProperties.put("spring.config.location", "classpath:/core/, classpath:/");
		return additionalProperties;
	}
}
