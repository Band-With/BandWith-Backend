package com.bandwith.dto.member;

import java.util.List;

public class MyPageDto {
    private int followerCount;
    private int followingCount;
    private List<BandDto> bands;

    public MyPageDto(){}

    public MyPageDto(int followerCount, int followingCount, List<BandDto> bands) {
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.bands = bands;
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
