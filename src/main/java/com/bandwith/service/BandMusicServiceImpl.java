package com.bandwith.service;

import com.bandwith.dao.*;
import com.bandwith.domain.Record;
import com.bandwith.dto.BandMusicSearchResultDto;
import com.bandwith.dto.bandMusic.BandMusicUpdateDto;
import com.bandwith.dto.bandMusic.BandMusicDetailDto;
import com.bandwith.dto.bandMusic.BandMusicInsertDto;
import com.bandwith.dto.bandMusic.RecordBandMusicDto;
import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import com.bandwith.dto.MixDetailDto;
import com.bandwith.dto.band.BandMusicRecordDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("bandMusicServiceBean")
public class BandMusicServiceImpl implements BandMusicService {

    private BandDao bandDao;
    private BandMusicDao bandMusicDao;
    private MusicDao musicDao;
    private RecordDao recordDao;
    private MemberDao memberDao;
    private LikeDao likeDao;
    private CommentDao commentDao;

    @Autowired
    public BandMusicServiceImpl(@Qualifier("bandDaoBean") BandDao bandDao,
                                @Qualifier("bandMusicDaoBean") BandMusicDao bandMusicDao,
                                @Qualifier("musicDaoBean") MusicDao musicDao,
                                @Qualifier("recordDaoBean") RecordDao recordDao,
                                @Qualifier("memberDaoBean") MemberDao memberDao,
                                @Qualifier("likeDaoBean") LikeDao likeDao,
                                @Qualifier("commentDaoBean") CommentDao commentDao) {
        this.bandDao = bandDao;
        this.bandMusicDao = bandMusicDao;
        this.musicDao = musicDao;
        this.recordDao = recordDao;
        this.memberDao = memberDao;
        this.likeDao = likeDao;
        this.commentDao = commentDao;
    }

    @Override
    public void insertBandMusic(BandMusicInsertDto bandMusicInsertDto) {
        Band band = bandDao.selectBandByName(bandMusicInsertDto.getBandName());
        bandMusicInsertDto.setBandId(band.getBand_id());
        bandMusicDao.insertBandMusic(bandMusicInsertDto);
        System.out.println("Band Music Insertion Completed");
    }

    @Override
    public BandMusicDetailDto getBandMusic(int bandMusicId){
        BandMusic bandMusic = bandMusicDao.select(bandMusicId);
        List<Member> members = memberDao.selectMemberBandMusic(bandMusicId);

        int musicId = bandMusic.getMusicId();
        Music music = musicDao.selectMusic(musicId);

        int likes = likeDao.bandMusicLike(bandMusicId);
        int comments = commentDao.bandMusicComments(bandMusicId);

        return BandMusicDetailDto.of(bandMusic, likes, comments, music, members);
    }

    public List<BandMusicSearchResultDto> searchBandMusic(String bandMusicTitle, String filter, String subject) throws Exception {
        List<BandMusic> bandMusicList;

        if (subject.equals("music")) {
            if (filter.equals("related"))
                bandMusicList = bandMusicDao.searchBandMusicTitle(bandMusicTitle);
            else if (filter.equals("like"))
                bandMusicList = bandMusicDao.searchBandMusicLike(bandMusicTitle);
            else
                throw new Exception();
        } else if (subject.equals("band")) {
            if (filter.equals("related"))
                bandMusicList = bandMusicDao.searchBandMusicBandTitle(bandMusicTitle);
            else if (filter.equals("like"))
                bandMusicList = bandMusicDao.searchBandMusicBandLike(bandMusicTitle);
            else
                throw new Exception();
        } else
            throw new Exception();


        List<BandMusicSearchResultDto> bandMusicSearchResultDto = new ArrayList<>();

        for (BandMusic bandMusic : bandMusicList) {
            int bandMusicId = bandMusic.getBandMusicId();
            Band band = bandDao.selectBandByBandMusicId(bandMusicId);

            List<Member> members = memberDao.selectMemberBandMusic(bandMusicId);
            int musicId = bandMusic.getMusicId();
            Music music = musicDao.selectMusic(musicId);

            int likes = likeDao.bandMusicLike(bandMusicId);
            int comments = commentDao.bandMusicComments(bandMusicId);

            bandMusicSearchResultDto.add(BandMusicSearchResultDto.of(bandMusic, likes, comments, music, members, band));
        }

        return bandMusicSearchResultDto;
    }

    @Override
    public List<String> getRecordUrls(int bandMusicId) throws Exception {
        List<Integer> recordIdList = bandMusicDao.selectRecordBandMusic(bandMusicId);
        if (recordIdList.size() <= 1)
            throw new Exception("There should be at least two recordings registered for band music.");

        return recordDao.selectRecordUrlsByIdList(recordIdList);
    }

    @Override
    public void insertRecordBandMusic(int bandMusicId, int recordId) {
        Record record = recordDao.selectRecord(recordId);
        RecordBandMusicDto recordBandMusicDto = new RecordBandMusicDto(bandMusicId, recordId, record.getMusicId(), record.getMemberId());

        bandMusicDao.insertRecordBandMusic(recordBandMusicDto);
    }

    @Override
    public void updateComplete(BandMusicUpdateDto bandMusicUpdateDto) {
        bandMusicDao.updateComplete(bandMusicUpdateDto);
    }

    @Override
    public void deleteBandMusic(int bandMusicId) {
        bandMusicDao.deleteBandMusic(bandMusicId);
        System.out.println("Band Music Deletion Completed");
    }

    public MixDetailDto getBandMusicRecords(String bandName, int bandMusicId){
        Music music = musicDao.selectMusicByBandMusicId(bandMusicId);

        List<BandMusicRecordDto> recordDtoList = new ArrayList<>();

        List<Record> records = recordDao.selectRecordByBandMusicId(bandMusicId);
        for(Record record: records){
            Member member = memberDao.selectMemberByRecordId(record.getRecordId());
            recordDtoList.add(new BandMusicRecordDto(MemberBasicDto.of(member), record.getRecordId(), record.getFileUrl()));
        }
        return new MixDetailDto(MusicDto.of(music), recordDtoList);
    }

    public void deleteBandMusicRecord(int bandMusicId, int recordId){
        bandMusicDao.deleteBandMusicRecord(bandMusicId, recordId);
    }
}
