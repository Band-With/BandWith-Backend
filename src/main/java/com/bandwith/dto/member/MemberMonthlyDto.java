package com.bandwith.dto.member;

import com.bandwith.domain.Member;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MemberMonthlyDto {
    private String username;
    private String profile;
    private int like;




    public MemberMonthlyDto(String username, byte[] profile, int like) {
        this.username = username;
        String photo = null;
        if(profile != null) {
            photo = new String(profile, StandardCharsets.UTF_8);
            if( photo.startsWith("\uFEFF") ) {
                photo = photo.substring(1);
            }
        }
        this.profile = photo;
        this.like = like;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}