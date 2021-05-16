package com.bandwith.dto.band;

public class BandMemberDto {
    int band_id;
    int member_id;
    String band_auth;

    public int getBand_id() {
        return band_id;
    }

    public void setBand_id(int band_id) {
        this.band_id = band_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getBand_auth() {
        return band_auth;
    }

    public void setBand_auth(String band_auth) {
        this.band_auth = band_auth;
    }

    public BandMemberDto(int band_id, int member_id, String band_auth) {
        this.band_id = band_id;
        this.member_id = member_id;
        this.band_auth = band_auth;
    }
}
