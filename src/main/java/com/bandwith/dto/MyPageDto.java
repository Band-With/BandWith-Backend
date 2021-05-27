package com.bandwith.dto;

import com.bandwith.dto.band.BandDto;
import com.bandwith.dto.member.MemberBasicDto;

import java.util.List;

public class MyPageDto {
    private MemberBasicDto member;
    private int followerCount;
    private int followingCount;

    private int piano;
    private int elec;
    private int base;
    private int sing;
    private int drum;

    private List<MemberBasicDto> followings;
    private List<MemberBasicDto> followers;
    private List<BandDto> bands;


    public MyPageDto(){}

    public MyPageDto(MemberBasicDto member, int followerCount, int followingCount, int piano, int elec, int base, int sing, int drum, List<MemberBasicDto> followings, List<MemberBasicDto> followers, List<BandDto> bands) {
        this.member = member;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.piano = piano;
        this.elec = elec;
        this.base = base;
        this.sing = sing;
        this.drum = drum;
        this.followings = followings;
        this.followers = followers;
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

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public int getElec() {
        return elec;
    }

    public void setElec(int elec) {
        this.elec = elec;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getSing() {
        return sing;
    }

    public void setSing(int sing) {
        this.sing = sing;
    }

    public int getDrum() {
        return drum;
    }

    public void setDrum(int drum) {
        this.drum = drum;
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
