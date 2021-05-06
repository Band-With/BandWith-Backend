package com.bandwith.dto.like;

public class LikeOnBandMusicDto {
    int memberId;
    int bandMusicId;

    public LikeOnBandMusicDto() {

    }

    public LikeOnBandMusicDto(int memberId, int bandMusicId) {
        this.memberId = memberId;
        this.bandMusicId = bandMusicId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBandMusicId() {
        return bandMusicId;
    }

    public void setBandMusicId(int bandMusicId) {
        this.bandMusicId = bandMusicId;
    }
}
