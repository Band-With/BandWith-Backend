package com.bandwith.service;

import com.bandwith.dto.band.BandMusicDetailDto;
import com.bandwith.dto.band.BandMusicInsertDto;

import java.util.List;

public interface BandMusicService {
    void createBandMusic(BandMusicInsertDto bandMusicInsertDto);
    BandMusicDetailDto getBandMusic(int bandMusicId);
    List<BandMusicDetailDto> searchBandMusic(String bandMusicTitle, String filter) throws Exception;
}
