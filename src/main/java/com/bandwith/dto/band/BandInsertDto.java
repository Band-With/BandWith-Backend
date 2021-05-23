package com.bandwith.dto.band;

import java.nio.charset.StandardCharsets;

public class BandInsertDto {
    private int bandId;
    private String bandName;
    private byte[] img;
    private String username;
    private int memberId;
    private String bandAuth;

    public BandInsertDto() {
        bandAuth = "admin";
    }

    public BandInsertDto(int bandId, String bandName, byte[] img, String username, int memberId, String bandAuth) {
        this.bandId = bandId;
        this.bandName = bandName;
        this.img = img;
        this.username = username;
        this.memberId = memberId;
        this.bandAuth = bandAuth;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img.getBytes(StandardCharsets.UTF_8);;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getBandAuth() {
        return bandAuth;
    }

    public void setBandAuth(String bandAuth) {
        this.bandAuth = bandAuth;
    }
}
