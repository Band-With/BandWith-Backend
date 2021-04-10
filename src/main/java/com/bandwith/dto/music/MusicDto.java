package com.bandwith.dto.music;

import com.bandwith.domain.Band;
import com.bandwith.domain.Music;
import com.bandwith.dto.band.BandDto;

import java.util.ArrayList;
import java.util.List;

public class MusicDto {
    private String title;
    private String singer;
    private String composer;
    private byte[] img;

    public MusicDto(String title, String singer, String composer, byte[] img) {
        this.title = title;
        this.singer = singer;
        this.composer = composer;
        this.img = img;
    }

    public static MusicDto of(Music music){
        return new MusicDto(music.getTitle(), music.getSinger(), music.getComposer(), music.getProfile_img());
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
