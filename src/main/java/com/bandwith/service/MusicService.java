package com.bandwith.service;

import com.bandwith.dto.music.MusicDto;

public interface MusicService {
    void find(MusicDto music);
    void insertMusic(MusicDto newMusic);
}
