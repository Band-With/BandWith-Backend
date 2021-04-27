package com.bandwith.service;


import com.bandwith.dao.MusicDao;
import com.bandwith.domain.Music;
import com.bandwith.dto.music.MusicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("musicServiceBean")
public class MusicServiceImpl implements MusicService {

    private final MusicDao musicDao;

    @Autowired
    public MusicServiceImpl(@Qualifier("musicDaoBean") MusicDao musicDao) {
        this.musicDao = musicDao;
    }

    public void find(MusicDto theMusic) {

    }

    @Override
    public void insertMusic(MusicDto newMusic) {
        Music music = Music.of(newMusic);
        musicDao.insertMusic(music);
    }

}
