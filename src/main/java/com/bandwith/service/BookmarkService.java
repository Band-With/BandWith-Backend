package com.bandwith.service;

import com.bandwith.dto.bookmark.BookmarkInsertDto;

public interface BookmarkService {
    void insertBookmark(BookmarkInsertDto bookmarkInsertDto);
    void deleteBookmark(int bookmarkId);
}
