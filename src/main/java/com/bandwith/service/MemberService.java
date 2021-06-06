package com.bandwith.service;

import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.member.MemberProfileUpdateDto;

import javax.servlet.http.HttpSession;

public interface MemberService {
    MemberDto getMember(String username);
    void signUp(MemberDto newMember);
    MemberDto signIn(MemberDto memberDto);
    String sendMail(String email);
    Boolean checkCode(String mail, String code, HttpSession session);
    void modifyProfile(MemberProfileUpdateDto memberProfileUpdateDto);
    void modifyPw(int memberId, String pwd);
}