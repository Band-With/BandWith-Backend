package com.bandwith.service;

import com.bandwith.dto.band.BandMusicDetailDto;
import com.bandwith.dto.band.BandMusicInsertDto;

public interface BandMusicService {
    BandMusicDetailDto getBandMusic(int bandMusicId);
    void createBandMusic(BandMusicInsertDto bandMusicInsertDto);
    void deleteBandMusic(int bandMusicId);
}
