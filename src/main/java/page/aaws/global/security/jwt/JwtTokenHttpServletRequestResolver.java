package page.aaws.global.security.jwt;

import jakarta.servlet.http.HttpServletRequest;

public interface JwtTokenHttpServletRequestResolver {
    String resolve(HttpServletRequest request);
}
