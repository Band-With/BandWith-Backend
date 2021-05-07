package com.bandwith.dao;

import com.bandwith.domain.Bookmark;
import com.bandwith.dto.bookmark.BookmarkInsertDto;

import java.util.HashMap;
import java.util.List;

public interface BookmarkDao {
    List<Bookmark> selectBookmarks(String username);
    int insertBookmark(BookmarkInsertDto bookmarkInsertDto);
    void insertRecordBookmark(HashMap<String, Object> params);
    void deleteBookmark(int bookmarkId);
    void deleteRecordBookmark(int bookmarkId);
}
