package com.bandwith.service;

import com.bandwith.dao.*;
import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import com.bandwith.domain.Record;
import com.bandwith.dto.MixDetailDto;
import com.bandwith.dto.band.BandMusicDetailDto;
import com.bandwith.dto.band.BandMusicInsertDto;
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
    private MemberDao memberDao;
    private LikeDao likeDao;
    private CommentDao commentDao;
    private RecordDao recordDao;

    @Autowired
    public BandMusicServiceImpl(@Qualifier("bandDaoBean") BandDao bandDao,
                                @Qualifier("bandMusicDaoBean") BandMusicDao bandMusicDao,
                                @Qualifier("musicDaoBean") MusicDao musicDao,
                                @Qualifier("memberDaoBean") MemberDao memberDao,
                                @Qualifier("likeDaoBean") LikeDao likeDao,
                                @Qualifier("commentDaoBean") CommentDao commentDao,
                                @Qualifier("recordDaoBean") RecordDao recordDao) {
        this.bandDao = bandDao;
        this.bandMusicDao = bandMusicDao;
        this.musicDao = musicDao;
        this.memberDao = memberDao;
        this.likeDao = likeDao;
        this.commentDao = commentDao;
        this.recordDao = recordDao;
    }

    @Override
    public void createBandMusic(BandMusicInsertDto bandMusicInsertDto) {
        Band band = bandDao.selectBandByName(bandMusicInsertDto.getBandName());
        bandMusicInsertDto.setBandId(band.getBand_id());
        bandMusicDao.insertBandMusic(bandMusicInsertDto);
        System.out.println("complete insert band music");
    }

    public BandMusicDetailDto getBandMusic(int bandMusicId){
        BandMusic bandMusic = bandMusicDao.select(bandMusicId);
        List<Member> members = memberDao.selectMemberBandMusic(bandMusicId);

        int musicId = bandMusic.getMusicId();
        Music music = musicDao.selectMusic(musicId);

        int likes = likeDao.bandMusicLike(bandMusicId);
        int comments = commentDao.bandMusicComments(bandMusicId);

        return BandMusicDetailDto.of(bandMusic, likes, comments, music, members);
    }

    public void addBandMusicRecord(){

    }

    public MixDetailDto getBandMusicRecords(String bandName, int bandMusicId){
        Music music = musicDao.selectMusicByBandMusicId(bandMusicId);

        List<BandMusicRecordDto> recordDtoList = new ArrayList<>();

        List<Record> records = recordDao.selectRecordByBandMusicId(bandMusicId);
        for(Record record: records){
            Member member = memberDao.selectMemberByRecordId(record.getRecordId());
            recordDtoList.add(new BandMusicRecordDto(MemberBasicDto.of(member), record.getFileUrl()));
        }
        return new MixDetailDto(MusicDto.of(music), recordDtoList);
    }
}
