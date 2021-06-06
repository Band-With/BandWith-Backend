package com.bandwith.dao;

import com.bandwith.domain.Member;
import com.bandwith.dto.member.MemberProfileUpdateDto;

import java.util.HashMap;
import java.util.List;

public interface MemberDao {
    int getMemberIdOf(String username);
    Member selectMemberWithUsername(String username);
    Member selectMember(int member_id);
    Member selectMember(String username);
    List<Member> selectMemberWithBookmark(int bookmark_id);
    List<Member> selectMemberBandMusic(int bandMusicId);
    Member selectMemberByRecordId(int recordId);

    void insertMember(Member member);

    void updateProfile(MemberProfileUpdateDto memberProfileUpdateDto);
    void updatePw(int memberId, String pwd);

    void deleteMember(String username);

    Member login(Member member);
    int countFollower(String username);
    int countFollowing(String username);
}