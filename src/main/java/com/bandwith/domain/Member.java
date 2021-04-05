package com.bandwith.domain;

import com.bandwith.dto.member.MemberDto;

import java.util.Date;

public class Member {
    private int id;
    private String username;
    private String pwd;
    private String name;
    private String profileImgUrl;
    private Date regDate;

    public Member() {
    }

    public Member(String username, String pwd, String name, String profileImgUrl) {
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.profileImgUrl = profileImgUrl;
    }

    public Member(int id, String username, String pwd, String name, String profileImgUrl, Date regDate) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.profileImgUrl = profileImgUrl;
        this.regDate = regDate;
    }

    public static Member of(MemberDto memberDto, String profileImgUrl){
        return new Member(memberDto.getUsername(), memberDto.getPwd(), memberDto.getName(), profileImgUrl);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
