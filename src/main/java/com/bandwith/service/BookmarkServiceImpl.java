package com.bandwith.service;

import com.bandwith.dao.BookmarkDao;
import com.bandwith.dto.bookmark.BookmarkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("bookmarkServiceBean")
public class BookmarkServiceImpl implements BookmarkService {
    private BookmarkDao bookmarkDao;

    @Autowired
    public BookmarkServiceImpl(@Qualifier("bookmarkDaoBean") BookmarkDao bookmarkDao) {
        this.bookmarkDao = bookmarkDao;
    }

    public BookmarkDto getBookmarks(String username) {
        return null;
    }
}
