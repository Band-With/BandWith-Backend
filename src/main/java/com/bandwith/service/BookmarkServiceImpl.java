package com.bandwith.service;

import com.bandwith.dao.*;
import com.bandwith.domain.Member;
import com.bandwith.dto.bookmark.BookmarkInsertDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("bookmarkServiceBean")
public class BookmarkServiceImpl implements BookmarkService {

    private BookmarkDao bookmarkDao;
    private MemberDao memberDao;

    @Autowired
    public BookmarkServiceImpl(@Qualifier("bookmarkDaoBean") BookmarkDao bookmarkDao,
                               @Qualifier("memberDaoBean") MemberDao memberDao) {
        this.memberDao = memberDao;
        this.bookmarkDao = bookmarkDao;
    }

    @Override
    public void insertBookmark(BookmarkInsertDto bookmarkInsertDto) {
        Member member = memberDao.selectMemberWithUsername(bookmarkInsertDto.getUsername());
        bookmarkInsertDto.setMemberId(member.getMember_id());

        int bookmarkId = bookmarkDao.insertBookmark(bookmarkInsertDto);

        for (int memberId : bookmarkInsertDto.getMembers()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("bookmarkId", bookmarkId);
            params.put("memberId", memberId);

            bookmarkDao.insertRecordBookmark(params);
        }
    }

    @Override
    public void deleteBookmark(int bookmarkId) {
        bookmarkDao.deleteRecordBookmark(bookmarkId);
        bookmarkDao.deleteBookmark(bookmarkId);
    }
}
