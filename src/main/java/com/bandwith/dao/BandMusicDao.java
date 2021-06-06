package com.bandwith.dao;

import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.dto.bandMusic.BandMusicUpdateDto;
import com.bandwith.dto.bandMusic.BandMusicInsertDto;
import com.bandwith.dto.bandMusic.RecordBandMusicDto;

import java.util.List;

public interface BandMusicDao {
    BandMusic select(int bandMusicId);
    List<Integer> selectRecordBandMusic(int bandMusicId);
//    Music getMusic(int music_id);


    int insertBandMusic(BandMusicInsertDto bandMusicinsertDto);
    int insertRecordBandMusic(RecordBandMusicDto recordBandMusicDto);
    void updateComplete(BandMusicUpdateDto bandMusicUpdateDto);
    void deleteBandMusic(int bandMusicId);
    List<Member> recordMember(int band_music_id);
    List<BandMusic> searchBandMusicTitle(String title);
    List<BandMusic> searchBandMusicLike(String title);
    List<BandMusic> searchBandMusicBandTitle(String title);
    List<BandMusic> searchBandMusicBandLike(String title);
    void deleteBandMusicRecord(int bandMusicId, int recordId);
}
