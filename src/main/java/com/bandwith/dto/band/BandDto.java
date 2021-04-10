package com.bandwith.dto.band;

import com.bandwith.domain.Band;

import java.util.ArrayList;
import java.util.List;

public class BandDto {
    private int band_id;
    private String band_name;
    private byte[] image;

    public BandDto(int band_id, String band_name, byte[] image) {
        this.band_id = band_id;
        this.band_name = band_name;
        this.image = image;
    }

    public static BandDto of(Band band){
        return new BandDto(band.getBand_id(), band.getBand_name(), band.getImg());
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
