package com.bandwith.dto.band;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.nio.charset.StandardCharsets;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BandMontlyDto {
    private int likes;
    private String bandName;
    private String img;

    public BandMontlyDto(int likes, String bandName, String img) {


        this.likes = likes;
        this.bandName = bandName;
        this.img = img;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}