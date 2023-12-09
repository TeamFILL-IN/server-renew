package com.teamfillin.fillin.domain.account.token;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class TokenConfiguration {
	@ConstructorBinding
	@ConfigurationProperties(prefix = "fillin.token.jwt")
	public static class JwtTokenProperties {
		private final String secret;
		private final long accessTokenValidityInMilli;
		private final long refreshTokenValidityInMilli;

		public JwtTokenProperties(String secret, long tokenValidityInMilli, long refreshTokenValidityInMilli) {
			this.secret = secret;
			this.accessTokenValidityInMilli = tokenValidityInMilli;
			this.refreshTokenValidityInMilli = refreshTokenValidityInMilli;
		}

		@NotNull
		public String getSecret() {
			return secret;
		}

		public long getAccessTokenValidityInMilli() {
			return accessTokenValidityInMilli;
		}

		public long getRefreshTokenValidityInMilli() {
			return refreshTokenValidityInMilli;
		}
	}
}
