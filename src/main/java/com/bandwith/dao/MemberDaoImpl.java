package com.bandwith.dao;

import com.bandwith.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public Member login(Member member) {
        return sqlSession.selectOne("MemberMapper.login", member);
    }

    public int countFollower(String username){ return sqlSession.selectOne("MemberMapper.countFollower", username); }

    public int countFollowing(String username){ return sqlSession.selectOne("MemberMapper.countFollowing", username); }
}
