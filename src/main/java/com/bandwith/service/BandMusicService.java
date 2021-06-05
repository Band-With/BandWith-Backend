package com.bandwith.service;

import com.bandwith.dto.bandMusic.BandMusicDetailDto;
import com.bandwith.dto.bandMusic.BandMusicInsertDto;
import com.bandwith.dto.bandMusic.BandMusicUpdateDto;

import java.util.List;

public interface BandMusicService {
    BandMusicDetailDto getBandMusic(int bandMusicId);
    List<String> getRecordUrls(int bandMusicId) throws Exception;

    void insertBandMusic(BandMusicInsertDto bandMusicInsertDto);
    void insertRecordBandMusic(int bandMusicId, int recordId);
    void updateComplete(BandMusicUpdateDto bandMusicUpdateDto);
    void deleteBandMusic(int bandMusicId);
}
