package com.bandwith.dao;

import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import com.bandwith.dto.band.BandMusicInsertDto;

import java.util.List;

public interface BandMusicDao {
    int insertBandMusic(BandMusicInsertDto bandMusicinsertDto);
    BandMusic select(int bandMusicId);
//    Music getMusic(int music_id);
    void deleteBandMusic(int bandMusicId);
    List<Member> recordMember(int band_music_id);
}
