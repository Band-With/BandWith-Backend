package com.bandwith.service;


import com.bandwith.dao.MusicDao;
import com.bandwith.domain.Music;
import com.bandwith.dto.music.MusicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("musicServiceBean")
public class MusicServiceImpl implements MusicService {

    private final MusicDao musicDao;

    @Autowired
    public MusicServiceImpl(@Qualifier("musicDaoBean") MusicDao musicDao) {
        this.musicDao = musicDao;
    }


    @Override
    @Transactional
    public List<MusicDto> search(String title, String filter) {

        List<Music> musics = musicDao.searchMusic(title, filter);

        List<MusicDto> musicDtoList = new ArrayList<>();

        if(musics.isEmpty()) return musicDtoList;

        for(Music music: musics){
            musicDtoList.add(this.convertEntityToDto(music));
        }

        return musicDtoList;
    }

    private MusicDto convertEntityToDto(Music music) {
        return MusicDto.builder()
                .music_id(music.getMusic_id())
                .title(music.getTitle())
                .singer(music.getSinger())
                .img(music.getProfile_img())
                .build();
    }
}
