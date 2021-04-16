package com.bandwith.service;

import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.PlaylistDto;
import com.bandwith.dto.bookmark.BookmarkDto;

import java.util.List;

public interface MyPageService {
    List<PlaylistDto> getMyRecord(String username);
    MyPageDto getMyPage(String username);
    List<BookmarkDto> getBookmarks(String username);
}
