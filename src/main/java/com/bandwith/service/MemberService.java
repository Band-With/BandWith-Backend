package com.bandwith.service;


import com.bandwith.domain.Member;
import com.bandwith.dto.member.MemberDto;

public interface MemberService {
    void signUp(MemberDto newMember);
    int signIn(Member member);
}