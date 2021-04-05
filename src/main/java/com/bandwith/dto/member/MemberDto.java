package com.bandwith.dto.member;

import java.util.Date;

public class MemberDto {
    private int id;
    private String username;
    private String pwd;
    private String name;
    private byte profileImg;
    private Date regDate;

    public MemberDto(){}

    public MemberDto(String username, String pwd, String name) {
        this.username = username;
        this.pwd = pwd;
        this.name = name;
    }

    public MemberDto(int id, String username, String pwd, String name, byte profileImg, Date regDate) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.profileImg = profileImg;
        this.regDate = regDate;
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

    public byte getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(byte profileImg) {
        this.profileImg = profileImg;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
