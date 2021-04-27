package com.bandwith.service;

import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.bookmark.BookmarkDto;
import com.bandwith.dto.music.MusicDto;

import java.util.List;

public interface MyPageService {
    List<MusicDto> getMyRecord(String username, Boolean condition);
    MyPageDto getMyPage(String username);
    List<BookmarkDto> getBookmarks(String username);
}
