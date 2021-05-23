package com.bandwith.dao;

import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import com.bandwith.dto.band.BandMusicInsertDto;

import java.util.List;

public interface BandMusicDao {
    int insertBandMusic(BandMusicInsertDto bandMusicinsertDto);
    Music getMusic(int music_id);

    List<Member> recordMember(int band_music_id);


}
