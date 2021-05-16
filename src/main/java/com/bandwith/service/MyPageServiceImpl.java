package com.bandwith.service;

import com.bandwith.dao.*;
import com.bandwith.domain.*;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.band.BandDto;
import com.bandwith.dto.bookmark.BookmarkDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.music.MusicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("myPageServiceBean")
public class MyPageServiceImpl implements MyPageService {
    private RecordDao recordDao;
    private MusicDao musicDao;
    private BandDao bandDao;
    private MemberDao memberDao;
    private BookmarkDao bookmarkDao;
    private FollowDao followDao;

    @Autowired
    public MyPageServiceImpl(@Qualifier("recordDaoBean") RecordDao recordDao,
                             @Qualifier("musicDaoBean") MusicDao musicDao,
                             @Qualifier("bandDaoBean") BandDao bandDao,
                             @Qualifier("memberDaoBean") MemberDao memberDao,
                             @Qualifier("bookmarkDaoBean") BookmarkDao bookmarkDao,
                             @Qualifier("followDaoBean") FollowDao followDao){
        this.recordDao = recordDao;
        this.musicDao = musicDao;
        this.bandDao = bandDao;
        this.memberDao = memberDao;
        this.bookmarkDao = bookmarkDao;
        this.followDao = followDao;
    }

    public MyPageDto getMyPage(String username){
        List<Band> newBands = bandDao.selectBands(username);
        List<BandDto> newBandsDto = BandDto.of(newBands);

        Member member = memberDao.selectMemberWithUsername(username);

        if (member == null)
            return null;

        MemberBasicDto memberBasicDto = MemberBasicDto.of(member);

        int followerCount = memberDao.countFollower(username);
        int followingCount = memberDao.countFollowing(username);

        int memberId = memberDao.getMemberIdOf(username);
        List<MemberBasicDto> followings = MemberBasicDto.of(followDao.getFollowings(memberId));
        List<MemberBasicDto> followers = MemberBasicDto.of(followDao.getFollowers(memberId));

        return new MyPageDto(memberBasicDto, followings, followers, followerCount, followingCount, newBandsDto);
    }

    public List<MusicDto> getMyRecord(String username, Boolean condition) {
        List<Music> musicList = new ArrayList<>();
        List<MusicDto> musicDtoList = new ArrayList<>();
        if(condition)
            musicList = musicDao.selectMusicMyPage(username);
        else
            musicList = musicDao.selectMusicOthersPage(username);
        return MusicDto.of(musicList);
    }

    public List<BookmarkDto> getBookmarks(String username) {
        List<Bookmark> bookmarks = bookmarkDao.selectBookmarks(username);
        List<BookmarkDto> bookmarksDto = new ArrayList<>();

        for (Bookmark bookmark: bookmarks) {
            int music_id = bookmark.getMusic_id();
            Music music = musicDao.selectMusic(music_id);
            MusicDto musicDto = MusicDto.of(music);

            int bookmark_id = bookmark.getBookmark_id();
            List<Member> members = memberDao.selectMemberWithBookmark(bookmark_id);
            List<MemberBasicDto> membersDto = MemberBasicDto.of(members);

            bookmarksDto.add(BookmarkDto.of(bookmark, membersDto, musicDto));
        }

        return bookmarksDto;
    }

}
