package com.bandwith.service;

import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.member.MusicDto;

public interface MusicService {
    void find(MusicDto music);
    void registerMusic(MusicDto newMusic);
}
