package com.bandwith.service;

import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.music.MusicDto;

import java.util.List;

public interface MusicService {
    MusicDto getMusic(int musicId);
    void insertMusic(MusicDto newMusic);
    List<MusicDto> search(String title, String filter);
}
