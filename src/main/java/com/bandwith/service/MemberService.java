package com.bandwith.service;


import com.bandwith.domain.Member;
import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.MyPageDto;

import javax.servlet.http.HttpSession;

public interface MemberService {
    void signUp(MemberDto newMember);
    MemberDto signIn(MemberDto memberDto);
    void sendMail(String email, HttpSession session);
    Boolean checkCode(String mail, String code, HttpSession session);
}