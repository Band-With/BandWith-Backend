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
}
