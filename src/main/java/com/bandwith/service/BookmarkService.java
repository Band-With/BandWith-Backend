package com.bandwith.service;

import com.bandwith.dto.bookmark.BookmarkDto;

public interface BookmarkService {
    BookmarkDto getBookmarks(String username);
}
