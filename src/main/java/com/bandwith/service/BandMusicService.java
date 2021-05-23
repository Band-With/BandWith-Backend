package com.bandwith.service;

import com.bandwith.dto.band.BandMusicDetailDto;
import com.bandwith.dto.band.BandMusicInsertDto;

public interface BandMusicService {
    void createBandMusic(BandMusicInsertDto bandMusicInsertDto);
    BandMusicDetailDto getBandMusic(int bandMusicId);
}
