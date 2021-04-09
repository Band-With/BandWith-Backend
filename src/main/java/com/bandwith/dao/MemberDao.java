package com.bandwith.dao;


import com.bandwith.domain.Member;
import com.bandwith.dto.member.MemberDto;

public interface MemberDao {
    void insertMember(Member member);
    int login(Member member);
    int countFollower(String username);
    int countFollowing(String username);
}