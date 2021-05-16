package com.bandwith.dto;

import com.bandwith.dto.band.BandDto;
import com.bandwith.dto.member.MemberBasicDto;

import java.util.List;

public class MyPageDto {
    private MemberBasicDto member;
    private int followerCount;
    private int followingCount;
    private List<MemberBasicDto> followings;
    private List<MemberBasicDto> followers;
    private List<BandDto> bands;

    public MyPageDto(){}

    public MyPageDto(MemberBasicDto member, List<MemberBasicDto> followings, List<MemberBasicDto> followers,
                     int followerCount, int followingCount, List<BandDto> bands) {
        this.member = member;
        this.followings = followings;
        this.followers = followers;
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

    public List<MemberBasicDto> getFollowings() {
        return followings;
    }

    public void setFollowings(List<MemberBasicDto> followings) {
        this.followings = followings;
    }

    public List<MemberBasicDto> getFollowers() {
        return followers;
    }

    public void setFollowers(List<MemberBasicDto> followers) {
        this.followers = followers;
    }

    public void addBand(BandDto newBand){
        this.bands.add(newBand);
    }
}
