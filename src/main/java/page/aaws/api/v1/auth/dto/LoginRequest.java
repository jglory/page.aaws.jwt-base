package page.aaws.api.v1.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import page.aaws.global.security.jwt.model.JsonUsernamePasswordAuthenticationRequest;

@Schema(description = "로그인 요청 DTO")
public record LoginRequest(
    @Email
    @NotBlank(message = "username is required")
    @Schema(description = "이메일(아이디)", example = "user@example.com")
    String email,

    @NotBlank
    @Schema(description = "비밀번호 (8자 이상, 영문+숫자+특수문자 조합)", example = "Password123!")
    String password
) implements JsonUsernamePasswordAuthenticationRequest {

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
