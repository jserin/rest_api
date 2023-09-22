package com.ll.rest_api.boundedContext.member.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //responsebody 안붙여도댐
@RequestMapping("/member")
public class MemberController {

    @PostMapping("/login")
    public String login() {
        return "redirect:/";
    }
}
