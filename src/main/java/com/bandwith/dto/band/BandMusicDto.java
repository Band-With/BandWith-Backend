package com.bandwith.dto.band;

import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.List;

public class BandMusicDto {

    private int band_music_id;
    private Timestamp complete_date;
    private Boolean complete;
    private MusicDto musicDto;
    private List<MemberBasicDto> memberBasicDtoList;
    private int likes;
    private int comments;



    public static BandMusicDto of(BandMusic bandMusic, MusicDto musicDto, List<MemberBasicDto> memberBasicDtoList, int likes, int comments){


        return new BandMusicDto(bandMusic.getBandMusicId(), bandMusic.getCompleteDate(), bandMusic.isComplete(), musicDto, memberBasicDtoList, likes, comments);
    }

    public BandMusicDto(int band_music_id, Timestamp complete_date, Boolean complete, MusicDto musicDto, List<MemberBasicDto> memberBasicDtoList, int likes, int comments) {
        this.band_music_id = band_music_id;
        this.complete_date = complete_date;
        this.complete = complete;
        this.musicDto = musicDto;
        this.memberBasicDtoList = memberBasicDtoList;
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

    public MusicDto getMusicDto() {
        return musicDto;
    }

    public void setMusicDto(MusicDto musicDto) {
        this.musicDto = musicDto;
    }

    public List<MemberBasicDto> getMemberBasicDtoList() {
        return memberBasicDtoList;
    }

    public void setMemberBasicDtoList(List<MemberBasicDto> memberBasicDtoList) {
        this.memberBasicDtoList = memberBasicDtoList;
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
