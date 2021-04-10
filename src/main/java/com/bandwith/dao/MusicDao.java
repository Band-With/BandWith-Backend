package com.bandwith.dao;

import com.bandwith.domain.Member;
import com.bandwith.domain.Music;

public interface MusicDao {
    void insertMusic(Music music);
    void deleteMusic(Music music);
    void searchMusic(Music music);
}
