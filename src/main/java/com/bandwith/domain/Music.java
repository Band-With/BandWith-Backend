package com.bandwith.domain;

import com.bandwith.dto.music.MusicDto;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Music {
    private int music_id;
    private String title;
    private String singer=null;
    private String composer=null;
    private String profile_img=null;

    public Music(int music_id, String title, String singer, String composer, String profile_img) {
        this.music_id = music_id;
        this.title = title;
        this.singer = singer;
        this.composer = composer;
        this.profile_img = profile_img;
    }


    

    public static Music of(MusicDto newMusic) {
        return new Music(newMusic.getMusic_id(),newMusic.getTitle(), newMusic.getSinger(), newMusic.getComposer(),null);

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

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }
}