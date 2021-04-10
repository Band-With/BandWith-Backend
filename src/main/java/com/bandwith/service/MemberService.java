package com.bandwith.service;


import com.bandwith.domain.Member;
import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.MyPageDto;

public interface MemberService {
    void signUp(MemberDto newMember);
    int signIn(Member member);
    MyPageDto getMyPage(String username);
}