package com.bandwith.dao;

import com.bandwith.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public Member selectMemberWithUsername(String username){
        return sqlSession.selectOne("MemberMapper.selectWithUsername", username);
    }

    @Override
    public Member selectMember(int member_id){
        return sqlSession.selectOne("MemberMapper.select", member_id);
    }

    @Override
    public Member login(Member member) {
        return sqlSession.selectOne("MemberMapper.login", member);
    }

    @Override
    public int countFollower(String username){
        return sqlSession.selectOne("MemberMapper.countFollower", username);
    }

    @Override
    public int countFollowing(String username){
        return sqlSession.selectOne("MemberMapper.countFollowing", username);
    }

    @Override
    public List<Member> selectMemberWithBookmark(int bookmark_id) {
        return sqlSession.selectList("MemberMapper.selectWithBookmark", bookmark_id);
    }

    @Override
    public void deleteMember(String username) {
        sqlSession.delete("MemberMapper.deleteMember", username);
    }

    public int getMemberIdOf(String username){ return sqlSession.selectOne("MemberMapper.getMemberId", username);}
}
