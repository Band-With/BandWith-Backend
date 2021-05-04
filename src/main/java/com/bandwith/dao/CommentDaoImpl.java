package com.bandwith.dao;

import com.bandwith.domain.Comment;
import com.bandwith.dto.comment.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<Comment> getRecordComments(int recordId){
        return sqlSession.selectList("CommentMapper.getRecordComments", recordId);
    }
}
