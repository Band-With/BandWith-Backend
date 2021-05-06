package com.bandwith.dto.music;

import com.bandwith.domain.Music;
import lombok.Builder;
import org.apache.ibatis.javassist.bytecode.ByteArray;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MusicDto {
    private int music_id;
    private String title;
    private String singer;
    private String composer;
    private byte[] img;

    @Builder
    public MusicDto(int music_id, String title, String singer, String composer, byte[] img) {
        this.music_id = music_id;
        this.title = title;
        this.singer = singer;
        this.composer = composer;
        this.img = img;
    }

    public static MusicDto of(Music music){
        byte[] photobyte = null;
        String photo = new String(photobyte); //변환


        if(music.getProfile_img() != null) {
            photo = new String(music.getProfile_img(), StandardCharsets.UTF_8);
            if( photo.startsWith("\uFEFF") ) {
                photo = photo.substring(1);
            }
        }
        return new MusicDto(music.getMusic_id(), music.getTitle(), music.getSinger(), music.getComposer(), photobyte);
    }
    public static List<MusicDto> of(List<Music> musics){
        List<MusicDto> musicsDto = new ArrayList<MusicDto>();
        for(Music music: musics)
            musicsDto.add(MusicDto.of(music));
        return musicsDto;
    }


    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
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
