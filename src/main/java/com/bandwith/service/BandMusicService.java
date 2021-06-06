package com.bandwith.service;

import com.bandwith.dto.BandMusicSearchResultDto;
import com.bandwith.dto.bandMusic.BandMusicDetailDto;
import com.bandwith.dto.bandMusic.BandMusicInsertDto;
import com.bandwith.dto.bandMusic.BandMusicUpdateDto;

import java.util.List;
import com.bandwith.dto.MixDetailDto;

import java.util.List;

public interface BandMusicService {
    BandMusicDetailDto getBandMusic(int bandMusicId);
    List<BandMusicSearchResultDto> searchBandMusic(String bandMusicTitle, String filter, String subject) throws Exception;
    List<String> getRecordUrls(int bandMusicId) throws Exception;

    void insertBandMusic(BandMusicInsertDto bandMusicInsertDto);
    void insertRecordBandMusic(int bandMusicId, int recordId);
    void updateComplete(BandMusicUpdateDto bandMusicUpdateDto);
    void deleteBandMusic(int bandMusicId);
    MixDetailDto getBandMusicRecords(String bandName, int bandMusicId);
    void deleteBandMusicRecord(int bandMusicId, int recordId);
}
