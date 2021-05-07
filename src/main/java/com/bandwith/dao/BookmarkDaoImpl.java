package com.bandwith.dao;

import com.bandwith.domain.Bookmark;
import com.bandwith.dto.bookmark.BookmarkInsertDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("bookmarkDaoBean")
public class BookmarkDaoImpl implements BookmarkDao {
    private SqlSession sqlSession;

    @Autowired
    public BookmarkDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Bookmark> selectBookmarks(String username) {
        return sqlSession.selectList("BookmarkMapper.selectBookmarks", username);
    }

    @Override
    public int insertBookmark(BookmarkInsertDto bookmarkInsertDto) {
        sqlSession.insert("BookmarkMapper.insertBookmark", bookmarkInsertDto);
        return bookmarkInsertDto.getBookmarkId();
    }

    @Override
    public void insertRecordBookmark(HashMap<String, Object> params) {
        sqlSession.insert("BookmarkMapper.insertRecordBookmark", params);
    }

    @Override
    public void deleteBookmark(int bookmarkId) {
        sqlSession.delete("BookmarkMapper.deleteBookmark", bookmarkId);
    }

    @Override
    public void deleteRecordBookmark(int bookmarkId) {
        sqlSession.delete("BookmarkMapper.deleteRecordBookmark", bookmarkId);
    }
}
