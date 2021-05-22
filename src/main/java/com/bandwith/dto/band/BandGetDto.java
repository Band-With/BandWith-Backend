package com.bandwith.dto.band;

import com.bandwith.domain.Band;
import com.bandwith.domain.Music;
import com.bandwith.dto.music.MusicDto;

import java.nio.charset.StandardCharsets;
import java.security.Timestamp;

public class BandGetDto {

    private int band_id;
    private String band_name;
    private String img;
    private Timestamp created_at;

    public static BandGetDto of(Band band){

        String photo = null;

        if(band.getImg() != null) {
            photo = new String(band.getImg(), StandardCharsets.UTF_8);
            if( photo.startsWith("\uFEFF") ) {
                photo = photo.substring(1);
            }
        }

        return new BandGetDto(band.getBand_id(),band.getBand_name(), photo, band.getCreated_at());
    }



    public BandGetDto(int band_id, String band_name, String img, Timestamp created_at) {
        this.band_id = band_id;
        this.band_name = band_name;
        this.img = img;
        this.created_at = created_at;
    }

    public int getBand_id() {
        return band_id;
    }

    public void setBand_id(int band_id) {
        this.band_id = band_id;
    }

    public String getBand_name() {
        return band_name;
    }

    public void setBand_name(String band_name) {
        this.band_name = band_name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
