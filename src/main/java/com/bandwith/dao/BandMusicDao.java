package com.bandwith.dao;

import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.domain.RecordBandMusic;
import com.bandwith.dto.bandMusic.BandMusicUpdateDto;
import com.bandwith.dto.bandMusic.BandMusicInsertDto;

import java.util.List;

public interface BandMusicDao {
    int insertBandMusic(BandMusicInsertDto bandMusicinsertDto);
    BandMusic select(int bandMusicId);
    List<Integer> selectRecordBandMusic(int bandMusicId);
//    Music getMusic(int music_id);
    void updateComplete(BandMusicUpdateDto bandMusicUpdateDto);
    void deleteBandMusic(int bandMusicId);
    List<Member> recordMember(int band_music_id);
}
