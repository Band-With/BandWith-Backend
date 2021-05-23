package com.bandwith.dao;

import com.bandwith.domain.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("followDaoBean")
public class FollowDaoImpl implements FollowDao{
    private SqlSession sqlSession;

    @Autowired
    public FollowDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public List<Member> getFollowings(int memberId) {
        return sqlSession.selectList("FollowMapper.getFollowings", memberId);
    }

    public List<Member> getFollowers(int memberId) {
        return sqlSession.selectList("FollowMapper.getFollowers", memberId);
    }

    public void follow(HashMap<String, Integer> params) {
        sqlSession.insert("FollowMapper.insertFollow", params);
    }

    public void unfollow(HashMap<String, Integer> params) {
        sqlSession.delete("FollowMapper.deleteFollow", params);
    }
}
