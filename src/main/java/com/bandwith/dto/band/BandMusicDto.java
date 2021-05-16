package com.bandwith.dto.band;

import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Bookmark;
import com.bandwith.dto.bookmark.BookmarkDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.List;

public class BandMusicDto {
    private int bandMusicId;
    private String bandName;
    private int bandId;
    private int musicId;
//    private Timestamp createdAt;
//    private boolean complete;
//    private Timestamp completeDate;
//    private String uuid;
//    private String fileName;
//    private String fileUrl;


    public BandMusicDto() {
    }

    public BandMusicDto(int bandMusicId, String bandName, int bandId, int musicId) {
        this.bandMusicId = bandMusicId;
        this.bandName = bandName;
        this.bandId = bandId;
        this.musicId = musicId;
    }

    public static BandMusicDto of(BandMusic bandMusic) {
        return new BandMusicDto(
                bandMusic.getBandMusicId(),
                null,
                bandMusic.getBandId(),
                bandMusic.getMusicId()
        );
    }

    public int getBandMusicId() {
        return bandMusicId;
    }

    public void setBandMusicId(int bandMusicId) {
        this.bandMusicId = bandMusicId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }
}
