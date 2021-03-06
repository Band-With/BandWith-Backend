package com.bandwith.dto.bandMusic;

import com.bandwith.domain.BandMusic;

public class BandMusicInsertDto {
    private int bandMusicId;
    private String bandName;
    private int bandId;
    private int musicId;

    public BandMusicInsertDto() {
    }

    public BandMusicInsertDto(int bandMusicId, String bandName, int bandId, int musicId) {
        this.bandMusicId = bandMusicId;
        this.bandName = bandName;
        this.bandId = bandId;
        this.musicId = musicId;
    }

    public static BandMusicInsertDto of(BandMusic bandMusic) {
        return new BandMusicInsertDto(
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
