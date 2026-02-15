package page.aaws.global.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import page.aaws.api.v1.auth.dto.LoginRequest;
import page.aaws.global.security.config.customizer.*;
import page.aaws.global.security.jwt.*;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.NullSecurityContextRepository;
import page.aaws.global.security.jwt.filter.*;
import page.aaws.global.security.jwt.provider.JwtAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableConfigurationProperties({JwtConfiguration.class})
@AllArgsConstructor
public class SecurityConfig {
    private final JwtConfiguration jwtConfiguration;

    @Bean
    @Order(1)
    public SecurityFilterChain reissueSecurityFilterChain(
            HttpSecurity http,
            JwtAuthenticationProvider jwtRefreshTokenAuthenticationProvider,
            BearerTokenResolver bearerTokenResolver,
            AuthenticationSuccessHandler authenticationSuccessHandler,
            AuthenticationFailureHandler authenticationFailureHandler
            ) throws Exception {
        
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(jwtRefreshTokenAuthenticationProvider)
                .build();
        http.authenticationManager(authenticationManager);

        http.securityMatcher("/api/v1/reissue")
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy((SessionCreationPolicy.STATELESS)))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/reissue").authenticated())
                .addFilterBefore(new JwtReissueAuthenticationFilter("/api/v1/reissue", authenticationManager, bearerTokenResolver, authenticationSuccessHandler, authenticationFailureHandler), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            AuthorizeHttpRequestsCustomizer authorizeHttpRequestsCustomizer,
            CsrfCustomizer csrfCustomizer,
            FormLoginCustomizer formLoginCustomizer,
            HttpBasicCustomizer httpBasicCustomizer,
            SessionManagementCustomizer sessionManagementCustomizer,
            JwtAuthenticationProvider jwtAccessTokenAuthenticationProvider,
            BearerTokenResolver bearerTokenResolver,
            AuthenticationSuccessHandler authenticationSuccessHandler,
            AuthenticationFailureHandler authenticationFailureHandler,
            ExceptionHandlingCustomizer exceptionHandlingCustomizer,
            ObjectMapper objectMapper) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(jwtAccessTokenAuthenticationProvider)
                .build();
        http.authenticationManager(authenticationManager);

        http.csrf(csrfCustomizer)
                .formLogin(formLoginCustomizer)
                .httpBasic(httpBasicCustomizer)
                .sessionManagement(sessionManagementCustomizer)
                .authorizeHttpRequests(authorizeHttpRequestsCustomizer)
                .exceptionHandling(exceptionHandlingCustomizer)
                .addFilterBefore(
                        new JwtAuthenticationFilter(authenticationManager, bearerTokenResolver),
                        UsernamePasswordAuthenticationFilter.class
                )
                .addFilterBefore(
                        this.jsonUsernamePasswordAuthenticationFilter(authenticationManager, authenticationSuccessHandler, authenticationFailureHandler, objectMapper), //this.createJsonUsernamePasswordAuthenticationFilter(authenticationManager),
                        UsernamePasswordAuthenticationFilter.class
                );
        return http.build();
    }

    private @NonNull UsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter(
        AuthenticationManager authenticationManager,
        AuthenticationSuccessHandler authenticationSuccessHandler,
        AuthenticationFailureHandler authenticationFailureHandler,
        ObjectMapper objectMapper) {
        JsonUsernamePasswordAuthenticationFilter<LoginRequest> JsonUsernamePasswordAuthenticationFilter = new JsonUsernamePasswordAuthenticationFilter<>(authenticationManager, LoginRequest.class, objectMapper) {};
        JsonUsernamePasswordAuthenticationFilter.setFilterProcessesUrl("/api/v1/login");
        JsonUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        JsonUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        JsonUsernamePasswordAuthenticationFilter.setSecurityContextRepository(new NullSecurityContextRepository());
        return JsonUsernamePasswordAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        return new DaoAuthenticationProvider(this.userDetailsService(this.passwordEncoder()));
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("user@example.com")
                .password(passwordEncoder.encode("password"))
                .roles("CUSTOMER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
