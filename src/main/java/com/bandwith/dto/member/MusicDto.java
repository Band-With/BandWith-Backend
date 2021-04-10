package com.bandwith.dto.member;


import java.util.Date;

public class MusicDto {
    private int music_id;
    private String title;
    private byte musicProfileImage;
    private String singer;
    private String composer;

    public MusicDto(int music_id, String title, byte musicProfileImage, String singer, String composer) {
        this.music_id = music_id;
        this.title = title;
        this.musicProfileImage = musicProfileImage;
        this.singer = singer;
        this.composer = composer;
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

    public byte getMusicProfileImage() {
        return musicProfileImage;
    }

    public void setMusicProfileImage(byte musicProfileImage) {
        this.musicProfileImage = musicProfileImage;
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
}
