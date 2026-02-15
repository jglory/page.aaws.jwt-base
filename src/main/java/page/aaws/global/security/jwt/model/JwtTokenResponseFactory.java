package page.aaws.global.security.jwt.model;

import org.springframework.security.core.Authentication;

@FunctionalInterface
public interface JwtTokenResponseFactory {
    JwtTokenResponse<?> create(String accessToken, String refreshToken, Authentication authentication);
}