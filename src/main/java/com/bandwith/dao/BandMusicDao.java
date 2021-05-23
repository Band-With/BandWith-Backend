package com.bandwith.dao;

import com.bandwith.domain.BandMusic;
import com.bandwith.dto.band.BandMusicInsertDto;

public interface BandMusicDao {
    int insertBandMusic(BandMusicInsertDto bandMusicinsertDto);
    BandMusic select(int bandMusicId);
}
