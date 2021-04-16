package com.bandwith.dto.member;

import com.bandwith.domain.Member;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class MemberDto {
    private int id;
    private String username;
    private String pwd;
    private String name;
    private String profileImg;
    private Date regDate;

    public MemberDto(){}

    public MemberDto(String username, String pwd, String name, String profileImg) {
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.profileImg = profileImg;
    }

    public MemberDto(int id, String username, String pwd, String name, String profileImg, Date regDate) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.profileImg = profileImg;
        this.regDate = regDate;
    }

    public static MemberDto of(Member member){
        String photo = null;
        if(member.getProfile_img() != null) {
            photo = new String(member.getProfile_img(), StandardCharsets.UTF_8);
            if( photo.startsWith("\uFEFF") ) {
                photo = photo.substring(1);
            }
        }
        return new MemberDto(member.getUsername(), member.getPwd(), member.getName(), photo);
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

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
