package com.bandwith.dao;

import com.bandwith.domain.Bookmark;

import java.util.List;

public interface BookmarkDao {
    List<Bookmark> selectBookmarks(String username);
}
