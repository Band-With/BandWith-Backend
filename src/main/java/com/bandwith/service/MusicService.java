package com.bandwith.service;

import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.music.MusicDto;

import java.util.List;

public interface MusicService {

    List<MusicDto> search(String title, String filter);
}
