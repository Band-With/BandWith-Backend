package com.bandwith.service;

import com.bandwith.dao.BandDao;
import com.bandwith.dao.BandMusicDao;
import com.bandwith.dao.MusicDao;
import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Music;
import com.bandwith.dto.band.BandMusicDetailDto;
import com.bandwith.dto.band.BandMusicInsertDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("bandMusicServiceBean")
public class BandMusicServiceImpl implements BandMusicService {

    private BandDao bandDao;
    private BandMusicDao bandMusicDao;
    private MusicDao musicDao;

    @Autowired
    public BandMusicServiceImpl(@Qualifier("bandDaoBean") BandDao bandDao,
                                @Qualifier("bandMusicDaoBean") BandMusicDao bandMusicDao,
                                @Qualifier("musicDaoBean") MusicDao musicDao) {
        this.bandDao = bandDao;
        this.bandMusicDao = bandMusicDao;
        this.musicDao = musicDao;
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
        int musicId = bandMusic.getMusicId();
        Music music = musicDao.selectMusic(musicId);
        return BandMusicDetailDto.of(bandMusic, music);
    }
}
