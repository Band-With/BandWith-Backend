package com.bandwith.dto.band;


import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Record;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.record.RecordForBandDto;

import java.util.List;

public class BandDetailDto {
    private BandGetDto bandGetDto;
    private List<MemberBasicDto> memberBasicDtoList;
    private List<BandMusicDto> bandMusicDtoList;
    private int totalLikes;

    public BandGetDto getBandGetDto() {
        return bandGetDto;
    }

    public void setBandGetDto(BandGetDto bandGetDto) {
        this.bandGetDto = bandGetDto;
    }

    public List<MemberBasicDto> getMemberBasicDtoList() {
        return memberBasicDtoList;
    }

    public void setMemberBasicDtoList(List<MemberBasicDto> memberBasicDtoList) {
        this.memberBasicDtoList = memberBasicDtoList;
    }

    public List<BandMusicDto> getBandMusicDtoList() {
        return bandMusicDtoList;
    }

    public void setBandMusicDtoList(List<BandMusicDto> bandMusicDtoList) {
        this.bandMusicDtoList = bandMusicDtoList;
    }

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public BandDetailDto(BandGetDto bandGetDto, List<MemberBasicDto> memberBasicDtoList, List<BandMusicDto> bandMusicDtoList, int totalLikes) {
        this.bandGetDto = bandGetDto;
        this.memberBasicDtoList = memberBasicDtoList;
        this.bandMusicDtoList = bandMusicDtoList;
        this.totalLikes = totalLikes;
    }
}
