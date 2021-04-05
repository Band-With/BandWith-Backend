package com.bandwith.service;


import com.bandwith.dto.member.MemberDto;

public interface MemberService {
    void signUp(MemberDto newMember);
    void signIn();
}