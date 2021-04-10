package com.bandwith.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bookmarkDaoBean")
public class BookmarkDaoImpl implements BookmarkDao {
    private SqlSession sqlSession;

    @Autowired
    public BookmarkDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
}
