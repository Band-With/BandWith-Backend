package com.bandwith.dao;

import com.bandwith.domain.Bookmark;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookmarkDaoBean")
public class BookmarkDaoImpl implements BookmarkDao {
    private SqlSession sqlSession;

    @Autowired
    public BookmarkDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public List<Bookmark> selectBookmarks(String username) {
        return this.sqlSession.selectList("BookmarkMapper.selectBookmarks", username);
    }
}
