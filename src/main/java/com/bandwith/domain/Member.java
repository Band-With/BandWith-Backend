package com.bandwith.domain;

import com.bandwith.dto.member.MemberDto;

import java.util.Date;

public class Member {
    private int member_id;
    private String username;
    private String pwd;
    private String name;
    private byte[] profile_img;
    private Date regDate;

    public Member() {
    }

    public Member(String username, String pwd, String name) {
        this.username = username;
        this.pwd = pwd;
        this.name = name;
    }

    public Member(int member_id, String username, String pwd, String name, byte[] profile_img, Date regDate) {
        this.member_id = member_id;
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.profile_img = profile_img;
        this.regDate = regDate;
    }

    public static Member of(MemberDto memberDto){
        return new Member(memberDto.getUsername(), memberDto.getPwd(), memberDto.getName());
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
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

    public byte[] getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(byte[] profile_img) {
        this.profile_img = profile_img;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
