package com.bandwith.dto.band;

import com.bandwith.domain.Band;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BandDto {
    private int band_id;
    private String band_name;
    private String img;

    public BandDto(int band_id, String band_name, String img) {
        this.band_id = band_id;
        this.band_name = band_name;
        this.img = img;
    }

    public static BandDto of(Band band){
        String photo = null;
        if(band.getImg() != null) {
            photo = new String(band.getImg(), StandardCharsets.UTF_8);
            if( photo.startsWith("\uFEFF") ) {
                photo = photo.substring(1);
            }
        }
        return new BandDto(band.getBand_id(), band.getBand_name(), photo);
    }

    public static List<BandDto> of(List<Band> bands){
        List<BandDto> bandDtos = new ArrayList<BandDto>();
        for(Band band: bands)
            bandDtos.add(BandDto.of(band));
        return bandDtos;
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
}
