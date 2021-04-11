package com.bandwith.dto.music;

import com.bandwith.domain.Band;
import com.bandwith.domain.Music;
import com.bandwith.dto.band.BandDto;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MusicDto {
    private String title;
    private String singer;
    private String composer;
    private String img;

    public MusicDto(String title, String singer, String composer, String img) {
        this.title = title;
        this.singer = singer;
        this.composer = composer;
        this.img = img;
    }

    public static MusicDto of(Music music){
        String photo = null;
        if(music.getProfile_img() != null) {
            photo = new String(music.getProfile_img(), StandardCharsets.UTF_8);
            if( photo.startsWith("\uFEFF") ) {
                photo = photo.substring(1);
            }
        }
        return new MusicDto(music.getTitle(), music.getSinger(), music.getComposer(), photo);
    }
    public static List<MusicDto> of(List<Music> musics){
        List<MusicDto> musicsDto = new ArrayList<MusicDto>();
        for(Music music: musics)
            musicsDto.add(MusicDto.of(music));
        return musicsDto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
