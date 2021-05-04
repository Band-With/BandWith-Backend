package com.bandwith.dao;

import com.bandwith.domain.Member;

import java.util.List;

public interface MemberDao {
    void insertMember(Member member);
    Member login(Member member);
    int countFollower(String username);
    int countFollowing(String username);
    Member selectMemberWithUsername(String username);
    Member selectMember(int member_id);
    List<Member> selectMemberWithBookmark(int bookmark_id);
    void deleteMember(String username);
}