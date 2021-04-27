package com.bandwith.dao;

import com.bandwith.domain.Music;

import java.util.List;

public interface MusicDao {
    Music selectMusic(int music_id);
    List<Music> selectMusicOthersPage(String username);
    List<Music> selectMusicMyPage(String username);
}
