package com.bandwith.dto.member;

public class BandDto {
    private String bandName;
    private byte image;

    public BandDto(String bandName, byte image) {
        this.bandName = bandName;
        this.image = image;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public byte getImage() {
        return image;
    }

    public void setImage(byte image) {
        this.image = image;
    }
}
