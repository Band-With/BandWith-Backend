package com.bandwith.dao;

import com.bandwith.domain.Member;

public interface MemberDao {
    void insertMember(Member member);
    Member login(Member member);
    int countFollower(String username);
    int countFollowing(String username);
}