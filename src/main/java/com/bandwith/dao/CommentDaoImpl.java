package com.bandwith.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("commentDaoBean")
public class CommentDaoImpl implements CommentDao {
    private SqlSession sqlSession;

    @Autowired
    public CommentDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int countComment(int record_id){
        return sqlSession.selectOne("CommentMapper.countComment", record_id);
    }
}
