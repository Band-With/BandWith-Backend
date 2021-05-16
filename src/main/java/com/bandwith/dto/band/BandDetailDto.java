package com.bandwith.dto.band;


import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Record;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.record.RecordForBandDto;

import java.util.List;

public class BandDetailDto {
    private int band_id;
    private String band_name;
    private byte[] img;
    private List<Member> members;
    private List<RecordForBandDto> records;


    public BandDetailDto(Band band, List<Member> members, List<RecordForBandDto> records) {
        this.band_id = band.getBand_id();
        this.band_name = band.getBand_name();
        this.img = band.getImg();
        this.members = members;
        this.records = records;

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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<RecordForBandDto> getRecords() {
        return records;
    }

    public void setRecords(List<RecordForBandDto> records) {
        this.records = records;
    }
}
