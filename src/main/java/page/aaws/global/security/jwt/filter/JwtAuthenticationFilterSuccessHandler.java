package page.aaws.global.security.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.aaws.api.v1.auth.dto.TokenResponse;
import page.aaws.global.exception.AppStatus;
import page.aaws.global.model.AppResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import page.aaws.global.security.jwt.JwtTokenManager;

import java.io.IOException;

@AllArgsConstructor
public class JwtAuthenticationFilterSuccessHandler implements AuthenticationSuccessHandler {
    protected final JwtTokenManager accessTokenManager;
    protected final JwtTokenManager refreshTokenManager;
    protected final ObjectMapper objectMapper;
    protected final TokenResponseFactory tokenResponseFactory;

    // 기본 생성자: 팩토리를 별도로 지정하지 않으면 기본 TokenResponse를 반환하도록 설정
    public JwtAuthenticationFilterSuccessHandler(JwtTokenManager accessTokenManager, JwtTokenManager refreshTokenManager, ObjectMapper objectMapper) {
        this(accessTokenManager, refreshTokenManager, objectMapper,
                (accessToken, refreshToken, authentication) -> TokenResponse.of(accessToken, refreshToken, "read write", "Bearer"));
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String accessToken = this.accessTokenManager.createToken((AbstractAuthenticationToken) authentication);
        String refreshToken = this.refreshTokenManager.createToken((AbstractAuthenticationToken) authentication);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        // 팩토리 메서드 호출 시점에 생성된 토큰을 전달하므로 문제 없음
        TokenResponse<?> tokenResponse = this.tokenResponseFactory.create(accessToken, refreshToken, authentication);
        AppResponse<TokenResponse<?>> appResponse = AppResponse.success(AppStatus.OK, tokenResponse);
        response.getWriter().write(this.objectMapper.writeValueAsString(appResponse));
    }

    @FunctionalInterface
    public interface TokenResponseFactory {
        TokenResponse<?> create(String accessToken, String refreshToken, Authentication authentication);
    }
}
