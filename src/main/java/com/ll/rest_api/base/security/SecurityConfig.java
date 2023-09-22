package com.ll.rest_api.base.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeHttpRequests ->
                        authorizeHttpRequests
                                .anyRequest().permitAll()
                );
//                .cors().disable() // 타 도메인에서 API 호출 가능
//                .csrf().disable() // CSRF 토큰 끄기
//                .httpBasic().disable() // httpBaic 로그인 방식 끄기
//                .formLogin().disable() // 폼 로그인 방식 끄기
//                .sessionManagement(sessionManagement ->
//                        sessionManagement.sessionCreationPolicy(STATELESS)
//                ); // 세션끄기

        return http.build();
    }
}
