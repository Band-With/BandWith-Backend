package com.bandwith.dao;

import com.bandwith.domain.Member;

import java.util.List;

public interface MemberDao {
    void insertMember(Member member);
    int login(Member member);
    int countFollower(String username);
    int countFollowing(String username);
    List<Member> selectMemberWithBookmark(int bookmark_id);
}