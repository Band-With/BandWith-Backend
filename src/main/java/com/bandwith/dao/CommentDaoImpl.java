package com.bandwith.dao;

import com.bandwith.domain.Comment;
import com.bandwith.dto.comment.CommentCreateDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("commentDaoBean")
public class CommentDaoImpl implements CommentDao {
    private SqlSession sqlSession;

    @Autowired
    public CommentDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int countComment(int record_id) {
        return sqlSession.selectOne("CommentMapper.countComment", record_id);
    }

    public List<Comment> getRecordComments(int recordId) {
        return sqlSession.selectList("CommentMapper.getRecordComments", recordId);
    }

    public List<Comment> getBandMusicComments(int bandMusicId) {
        return sqlSession.selectList("CommentMapper.getBandMusicComments", bandMusicId);
    }

    public void createComment(CommentCreateDto comment) {
        sqlSession.insert("CommentMapper.insertComment", comment);
    }

    public void updateComment(HashMap<String, Object> params) {
        sqlSession.update("CommentMapper.updateComment", params);
    }

    public void deleteComment(int commentId) {
        sqlSession.delete("CommentMapper.deleteComment", commentId);
    }

    @Override
    public int bandMusicComments(int band_music_id) {
        if(sqlSession.selectOne("CommentMapper.bandMusicComment", band_music_id)!=null) {
            return sqlSession.selectOne("CommentMapper.bandMusicComment", band_music_id);
        }else{
            return 0;
        }
    }

}
