package com.bandwith.service;

import com.bandwith.dao.BandDao;
import com.bandwith.dao.BandMusicDao;
import com.bandwith.domain.Band;
import com.bandwith.dto.band.BandMusicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("bandMusicServiceBean")
public class BandMusicServiceImpl implements BandMusicService {

    private BandDao bandDao;
    private BandMusicDao bandMusicDao;

    @Autowired
    public BandMusicServiceImpl(@Qualifier("bandDaoBean") BandDao bandDao,
                                @Qualifier("bandMusicDaoBean") BandMusicDao bandMusicDao) {
        this.bandDao = bandDao;
        this.bandMusicDao = bandMusicDao;
    }

    @Override
    public void createBandMusic(BandMusicDto bandMusicDto) {
        Band band = bandDao.selectBandByName(bandMusicDto.getBandName());
        bandMusicDto.setBandId(band.getBand_id());
        bandMusicDao.insertBandMusic(bandMusicDao);
        System.out.println("complete insert band music");
    }
}
