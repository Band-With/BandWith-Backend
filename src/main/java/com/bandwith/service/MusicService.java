package com.bandwith.service;

import com.bandwith.dto.music.MusicDto;

public interface MusicService {
    MusicDto getMusic(int musicId);
    void insertMusic(MusicDto newMusic);
}
