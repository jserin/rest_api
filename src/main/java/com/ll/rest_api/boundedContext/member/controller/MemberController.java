package com.ll.rest_api.boundedContext.member.controller;

import com.ll.rest_api.base.rsData.RsData;
import com.ll.rest_api.boundedContext.member.entity.Member;
import com.ll.rest_api.boundedContext.member.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController //responsebody 안붙여도댐
@RequestMapping(value = "/member", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE) // json을 생산하고 입력받는것도 json임을 명시
public class MemberController {
    private final MemberService memberService;

    @Data
    public static class LoginRequest {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
    }

    @AllArgsConstructor
    @Getter
    public static class LoginResponse {
        private final String accessToken;
    }

    @PostMapping("/login")//requestBody가 있어야 json으로 받은 파일 해석할 수 있음
    public RsData<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse resp) {
        String accessToken = memberService.genAccessToken(loginRequest.getUsername(), loginRequest.getPassword());

        return RsData.of("S-1", "엑세스 토큰 생성 완료", new LoginResponse(accessToken));
    }
}
