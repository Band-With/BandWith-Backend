package com.bandwith.dto.band;


import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Record;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.record.RecordForBandDto;

import java.util.List;

public class BandDetailDto {
    private BandGetDto band;
    private List<MemberBasicDto> members;
    private List<BandDetailMusicDto> band_musics;
    private int totalLikes;

    public BandGetDto getBandGetDto() {
        return band;
    }

    public void setBandGetDto(BandGetDto band) {
        this.band = band;
    }

    public List<MemberBasicDto> getMemberBasicDtoList() {
        return members;
    }

    public void setMemberBasicDtoList(List<MemberBasicDto> members) {
        this.members = members;
    }

    public List<BandDetailMusicDto> getBandMusicDtoList() {
        return band_musics;
    }

    public void setBandMusicDtoList(List<BandDetailMusicDto> band_musics) {
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
