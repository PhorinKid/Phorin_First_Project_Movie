package org.big.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.headers(headers -> headers.cacheControl(cache -> cache.disable()) // 캐시 방지
				.contentTypeOptions(content -> content.disable()) // MIME 타입 강제 설정 해제
				.xssProtection(xss -> xss.disable()) // XSS 보호 비활성화
				.frameOptions(frame -> frame.sameOrigin()) // X-Frame-Options SAMEORIGIN 설정
		).csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/member/*", "/controller/*", "/service/*", "/error", "/error/*",
				"/img/**", "/favicon.ico");
	}

	@Bean
	public HttpFirewall defaultHttpFirewall() {
		return new DefaultHttpFirewall();
	}
}