package com.bandwith.domain;

import com.bandwith.dto.member.MemberDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member {
    private int member_id;
    private String username=null;
    private String pwd;
    private String name;
    private byte[] profile_img=null;
    private Timestamp reg_date;
    private String email;

    public Member() {
    }

    public Member(int member_id, String username, String pwd, String name, byte[] profile_img, Timestamp reg_date, String email) {
        this.member_id = member_id;
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.profile_img = profile_img;
        this.reg_date = reg_date;
        this.email = email;
    }

    public Member(String username, String pwd, String name, String email) {
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
    }

    public static Member of(MemberDto memberDto){
        return new Member(memberDto.getUsername(), memberDto.getPwd(), memberDto.getName(), memberDto.getEmail());
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

    public Timestamp getReg_date() {
        return reg_date;
    }

    public void setReg_date(Timestamp reg_date) {
        this.reg_date = reg_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
