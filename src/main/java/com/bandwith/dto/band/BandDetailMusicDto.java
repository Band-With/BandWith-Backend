package com.bandwith.dto.band;

import com.bandwith.domain.BandMusic;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;

import java.sql.Timestamp;
import java.util.List;

public class BandDetailMusicDto {

    private int band_music_id;
    private Timestamp complete_date;
    private Boolean complete;
    private MusicDto music;
    private List<MemberBasicDto> members;
    private int likes;
    private int comments;



    public static BandDetailMusicDto of(BandMusic bandMusic, MusicDto musicDto, List<MemberBasicDto> members, int likes, int comments){


        return new BandDetailMusicDto(bandMusic.getBandMusicId(), bandMusic.getCompleteDate(), bandMusic.isComplete(), musicDto, members, likes, comments);
    }

    public BandDetailMusicDto(int band_music_id, Timestamp complete_date, Boolean complete, MusicDto music, List<MemberBasicDto> members, int likes, int comments) {
        this.band_music_id = band_music_id;
        this.complete_date = complete_date;
        this.complete = complete;
        this.music = music;
        this.members = members;
        this.likes = likes;
        this.comments = comments;
    }

    public int getBand_music_id() {
        return band_music_id;
    }

    public void setBand_music_id(int band_music_id) {
        this.band_music_id = band_music_id;
    }

    public Timestamp getComplete_date() {
        return complete_date;
    }

    public void setComplete_date(Timestamp complete_date) {
        this.complete_date = complete_date;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public MusicDto getMusic() {
        return music;
    }

    public void setMusic(MusicDto music) {
        this.music = music;
    }

    public List<MemberBasicDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberBasicDto> members) {
        this.members = members;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }
}