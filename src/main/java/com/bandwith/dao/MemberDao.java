package com.bandwith.dao;

import com.bandwith.domain.Member;

import java.util.List;

public interface MemberDao {
    int getMemberIdOf(String username);
    void insertMember(Member member);
    Member login(Member member);
    int countFollower(String username);
    int countFollowing(String username);
    Member selectMemberWithUsername(String username);
    Member selectMember(int member_id);
    List<Member> selectMemberWithBookmark(int bookmark_id);
    List<Member> selectMemberBandMusic(int bandMusicId);
    Member selectMemberByRecordId(int recordId);
    void deleteMember(String username);
}