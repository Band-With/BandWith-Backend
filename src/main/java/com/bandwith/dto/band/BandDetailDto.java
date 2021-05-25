package com.bandwith.dto.band;


import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Record;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.record.RecordForBandDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BandDetailDto {
    private BandGetDto band=null;
    private List<MemberBasicDto> members=null;
    private List<BandDetailMusicDto> band_musics=null;
    private int totalLikes;

    public BandGetDto getBand() {
        return band;
    }

    public void setBand(BandGetDto band) {
        this.band = band;
    }

    public List<MemberBasicDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberBasicDto> members) {
        this.members = members;
    }

    public List<BandDetailMusicDto> getBand_musics() {
        return band_musics;
    }

    public void setBand_musics(List<BandDetailMusicDto> band_musics) {
        this.band_musics = band_musics;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public BandDetailDto(BandGetDto band, List<MemberBasicDto> members, List<BandDetailMusicDto> band_musics, int totalLikes) {
        this.band = band;
        this.members = members;
        this.band_musics = band_musics;
        this.totalLikes = totalLikes;
    }
}
