package com.bandwith.service;

import com.bandwith.dao.*;
import com.bandwith.domain.Band;
import com.bandwith.domain.Music;
import com.bandwith.domain.Record;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.PlaylistDto;
import com.bandwith.dto.band.BandDto;
import com.bandwith.dto.bookmark.BookmarkDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("recordServiceBean")
public class MyPageServiceImpl implements MyPageService {
    private RecordDao recordDao;
    private MusicDao musicDao;
    private BandDao bandDao;
    private MemberDao memberDao;
    private BookmarkDao bookmarkDao;

    @Autowired
    public MyPageServiceImpl(@Qualifier("recordDaoBean") RecordDao recordDao,
                             @Qualifier("musicDaoBean") MusicDao musicDao,
                             @Qualifier("bandDaoBean") BandDao bandDao,
                             @Qualifier("memberDaoBean") MemberDao memberDao,
                             @Qualifier("bookmarkDaoBean") BookmarkDao bookmarkDao){
        this.recordDao = recordDao;
        this.musicDao = musicDao;
        this.bandDao = bandDao;
        this.memberDao = memberDao;
        this.bookmarkDao = bookmarkDao;
    }

    public MyPageDto getMyPage(String username){
        List<Band> newBands = bandDao.selectBands(username);
        List<BandDto> newBandsDto = BandDto.of(newBands);

        int followers = memberDao.countFollower(username);
        int followings = memberDao.countFollowing(username);

        MyPageDto myPageDto = new MyPageDto(followers, followings, newBandsDto);

        return myPageDto;
    }

    public List<PlaylistDto> getMyRecord(String username) {
        List<Record> records = recordDao.selectRecords(username);
        List<RecordDto> recordsDto = RecordDto.of(records);

        List<PlaylistDto> playlistsDto = new ArrayList<PlaylistDto>();
        for (int i=0; i < records.size(); i++){
            int music_id = recordsDto.get(i).getMusic_id();
            Music music = musicDao.selectMusic(music_id);
            MusicDto musicDto = MusicDto.of(music);
            playlistsDto.add(new PlaylistDto(recordsDto.get(i), musicDto));
        }

        return playlistsDto;
    }

    public BookmarkDto getBookmarks(String username) {
        return null;
    }

}
