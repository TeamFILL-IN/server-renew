package com.teamfillin.fillin.domain.account.token;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.teamfillin.fillin.domain.account.AccountAccessResult;
import com.teamfillin.fillin.domain.account.SocialType;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenHandler {
	private static final String CLAIM_SOCIAL_TYPE = "socialType";
	private static final String CLAIM_ACCOUNT_NO = "accountNo";
	private static final String CLAIM_USER_NO = "userNo";

	private final TokenConfiguration.JwtTokenProperties jwtTokenProperties;
	private final SecretKey key;

	public JwtTokenHandler(TokenConfiguration.JwtTokenProperties jwtTokenProperties) {
		this.jwtTokenProperties = jwtTokenProperties;
		this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtTokenProperties.getSecret()));
	}

	public TokenResult generateFrom(@NotNull AccountAccessResult accountAccessResult) {
		final SocialType socialType = accountAccessResult.getSocialType();
		final long accountNo = accountAccessResult.getAccountNo();
		final long userNo = accountAccessResult.getUserNo();
		final long now = Instant.EPOCH.toEpochMilli();

		final String accessToken = Jwts.builder()
			.claims(makeClaims(socialType, accountNo, userNo))
			.signWith(key)
			.expiration(new Date(now + jwtTokenProperties.getAccessTokenValidityInMilli()))
			.compact();

		final String refreshToken = Jwts.builder()
			.signWith(key)
			.expiration(new Date(now + jwtTokenProperties.getRefreshTokenValidityInMilli()))
			.compact();

		return TokenResult.builder()
			.accessToken(accessToken)
			.refreshToken(refreshToken)
			.build();
	}

	public ValidateResult validateToken(@NotNull String token) {
		ValidateResult validateResult;
		try {
			Jwts.parser().verifyWith(key).build().parseEncryptedClaims(token);
			validateResult = ValidateResult.valid();
		} catch (SecurityException | MalformedJwtException e) {
			validateResult = ValidateResult.invalid("잘못된 JWT 서명입니다.");
		} catch (ExpiredJwtException e) {
			validateResult = ValidateResult.invalid("만료된 JWT 서명입니다.");
		} catch (Throwable t) {
			validateResult = ValidateResult.invalid("잘못된 혹은 지원하지 않는 토큰입니다.");
		}

		return validateResult;
	}

	private Map<String, String> makeClaims(SocialType socialType, long accountNo, long userNo) {
		final Map<String, String> claimMap = Maps.newHashMap();
		claimMap.put(CLAIM_SOCIAL_TYPE, socialType.name());
		claimMap.put(CLAIM_ACCOUNT_NO, String.valueOf(accountNo));
		claimMap.put(CLAIM_USER_NO, String.valueOf(userNo));

		return claimMap;
	}

	public static class ValidateResult {
		private final boolean isValid;
		private final String invalidReason;

		private ValidateResult(boolean isValid) {
			this.isValid = isValid;
			this.invalidReason = null;
		}

		private ValidateResult(boolean isValid, String invalidReason) {
			this.isValid = isValid;
			this.invalidReason = invalidReason;
		}

		public static ValidateResult valid() {
			return new ValidateResult(true);
		}

		public static ValidateResult invalid(@NotNull String reason) {
			return new ValidateResult(false, reason);
		}

		public boolean isValid() {
			return isValid;
		}

		@Nullable
		public String getInvalidReason() {
			return invalidReason;
		}
	}
}
