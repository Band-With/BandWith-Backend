package com.bandwith.service;

import com.bandwith.dao.*;
import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import com.bandwith.dto.band.BandMusicDetailDto;
import com.bandwith.dto.band.BandMusicInsertDto;
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

    @Autowired
    public BandMusicServiceImpl(@Qualifier("bandDaoBean") BandDao bandDao,
                                @Qualifier("bandMusicDaoBean") BandMusicDao bandMusicDao,
                                @Qualifier("musicDaoBean") MusicDao musicDao,
                                @Qualifier("memberDaoBean") MemberDao memberDao,
                                @Qualifier("likeDaoBean") LikeDao likeDao,
                                @Qualifier("commentDaoBean") CommentDao commentDao) {
        this.bandDao = bandDao;
        this.bandMusicDao = bandMusicDao;
        this.musicDao = musicDao;
        this.memberDao = memberDao;
        this.likeDao = likeDao;
        this.commentDao = commentDao;
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

    public List<BandMusicDetailDto> searchBandMusic(String bandMusicTitle, String filter) throws Exception {
        List<BandMusic> bandMusicList;

        if(filter.equals("related"))
            bandMusicList = bandMusicDao.searchBandMusicTitle(bandMusicTitle);
        else if(filter.equals("like"))
            bandMusicList = bandMusicDao.searchBandMusicLike(bandMusicTitle);
        else
            throw new Exception();

        List<BandMusicDetailDto> bandMusicDetailDtoList = new ArrayList<>();

        for (BandMusic bandMusic: bandMusicList){
            int bandMusicId = bandMusic.getBandMusicId();

            List<Member> members = memberDao.selectMemberBandMusic(bandMusicId);
            int musicId = bandMusic.getMusicId();
            Music music = musicDao.selectMusic(musicId);

            int likes = likeDao.bandMusicLike(bandMusicId);
            int comments = commentDao.bandMusicComments(bandMusicId);

            bandMusicDetailDtoList.add(BandMusicDetailDto.of(bandMusic, likes, comments, music, members));
        }

        return bandMusicDetailDtoList;
    }
}
