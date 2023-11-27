package com.ll.rest_api.boundedContext.member.dto;

import com.ll.rest_api.boundedContext.member.entity.Member;

import java.time.LocalDateTime;

public class MemberDto {
    private Long id;
    private LocalDateTime regDate;
    private String username;

    private MemberDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.regDate = member.getCreateDate();
    }

    public static MemberDto of(Member member) {
        return new MemberDto(member);
    }
}
