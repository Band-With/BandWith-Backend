package com.bandwith.dto.bandMusic;

public class RecordBandMusicDto {
    private int bandMusicId;
    private int recordId;
    private int musicId;
    private int memberId;

    public RecordBandMusicDto(int bandMusicId, int recordId, int musicId, int memberId) {
        this.bandMusicId = bandMusicId;
        this.recordId = recordId;
        this.musicId = musicId;
        this.memberId = memberId;
    }

    public int getBandMusicId() {
        return bandMusicId;
    }

    public void setBandMusicId(int bandMusicId) {
        this.bandMusicId = bandMusicId;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
