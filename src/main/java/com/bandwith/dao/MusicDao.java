package com.bandwith.dao;

import com.bandwith.domain.Music;

import java.util.List;

public interface MusicDao {
    Music selectMusic(int music_id);
    Music getMusicById(int musicId);
    Music selectMusicByTitle(String title);
    List<Music> selectMusics();
    List<Music> selectMusicOthersPage(String username);
    List<Music> selectMusicMyPage(String username);
    void insertMusic(Music music);
    void deleteMusic(Music music);
    List<Music> searchMusic(String title, String filter);
}
