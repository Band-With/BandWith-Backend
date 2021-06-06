package com.bandwith.dao;

import com.bandwith.domain.Member;
import com.bandwith.dto.member.MemberProfileUpdateDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("memberDaoBean")
public class MemberDaoImpl implements MemberDao {

    private final SqlSession sqlSession;

    @Autowired
    public MemberDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertMember(Member member) {
        sqlSession.insert("MemberMapper.insertMember", member);
    }

    @Override
    public void updateProfile(MemberProfileUpdateDto memberProfileUpdateDto) {
        sqlSession.update("MemberMapper.updateProfile", memberProfileUpdateDto);
    }

    @Override
    public void updatePw(int memberId, String pwd) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("memberId", memberId);
        params.put("pwd", pwd);
        sqlSession.update("MemberMapper.updatePw", params);
    }

    @Override
    public Member selectMemberWithUsername(String username) {
        return sqlSession.selectOne("MemberMapper.selectWithUsername", username);
    }

    @Override
    public Member selectMember(int member_id) {
        return sqlSession.selectOne("MemberMapper.select", member_id);
    }

    @Override
    public Member selectMember(String username) {
        return sqlSession.selectOne("MemberMapper.selectMember", username);
    }

    @Override
    public Member login(Member member) {
        return sqlSession.selectOne("MemberMapper.login", member);
    }

    @Override
    public int countFollower(String username) {
        return sqlSession.selectOne("MemberMapper.countFollower", username);
    }

    @Override
    public int countFollowing(String username) {
        return sqlSession.selectOne("MemberMapper.countFollowing", username);
    }

    @Override
    public List<Member> selectMemberWithBookmark(int bookmark_id) {
        return sqlSession.selectList("MemberMapper.selectWithBookmark", bookmark_id);
    }

    @Override
    public List<Member> selectMemberBandMusic(int bandMusicId) {
        return sqlSession.selectList("MemberMapper.selectWithBandMusic", bandMusicId);
    }

    @Override
    public void deleteMember(String username) {
        sqlSession.delete("MemberMapper.deleteMember", username);
    }

    public int getMemberIdOf(String username) {
        return sqlSession.selectOne("MemberMapper.getMemberId", username);
    }

    public Member selectMemberByRecordId(int recordId) {
        return sqlSession.selectOne("MemberMapper.selectByRecordId", recordId);
    }

}
