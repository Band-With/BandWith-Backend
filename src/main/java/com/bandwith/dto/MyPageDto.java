package com.bandwith.dto;

import com.bandwith.dto.band.BandDto;
import com.bandwith.dto.member.MemberBasicDto;

import java.util.List;

public class MyPageDto {
    private MemberBasicDto member;
    private int followerCount;
    private int followingCount;
    private List<BandDto> bands;

    public MyPageDto(){}

    public MyPageDto(MemberBasicDto member, int followerCount, int followingCount, List<BandDto> bands) {
        this.member = member;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.bands = bands;
    }

    public MemberBasicDto getMember() {
        return member;
    }

    public void setMember(MemberBasicDto member) {
        this.member = member;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public List<BandDto> getBands() {
        return bands;
    }

    public void setBands(List<BandDto> bands) {
        this.bands = bands;
    }

    public void addBand(BandDto newBand){
        this.bands.add(newBand);
    }
}
