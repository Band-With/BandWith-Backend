package com.bandwith.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("likeDaoBean")
public class LikeDaoImpl implements LikeDao{
    private SqlSession sqlSession;

    @Autowired
    public LikeDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int countLike(int record_id){
        System.out.println(record_id);
        return sqlSession.selectOne("LikeMapper.countLike", record_id);
    }
}
