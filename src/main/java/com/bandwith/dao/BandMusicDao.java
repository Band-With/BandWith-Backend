package com.bandwith.dao;

import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;

import java.util.List;

public interface BandMusicDao {
    Band insertBandMusic(BandMusicDao bandMusicDao);
    Music getMusic(int music_id);

    List<Member> recordMember(int band_music_id);

}
