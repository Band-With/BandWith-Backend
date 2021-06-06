package com.bandwith.dto.music;

import com.bandwith.domain.Music;
import com.bandwith.dto.member.MemberDto;
import lombok.Builder;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MusicDto {
    private int music_id;
    private String title;
    private String singer;
    private String composer;
    private String img;

    @Builder
    public MusicDto(int music_id, String title, String singer, String composer, String img) {
        this.music_id = music_id;
        this.title = title;
        this.singer = singer;
        this.composer = composer;
        this.img = img;
    }

    public static MusicDto of(Music music){
        return new MusicDto(music.getMusic_id(), music.getTitle(), music.getSinger(), music.getComposer(), music.getProfile_img());
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
