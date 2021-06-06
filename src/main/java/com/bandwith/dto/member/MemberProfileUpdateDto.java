package com.bandwith.dto.member;

import java.nio.charset.StandardCharsets;

public class MemberProfileUpdateDto {
    private int memberId;
    private String name;
    private byte[] profileImg;

    public MemberProfileUpdateDto(){
    }

    public MemberProfileUpdateDto(int memberId, String name, String profileImg) {
        this.memberId = memberId;
        this.name = name;
        setProfileImg(profileImg);
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        if (profileImg != null)
            this.profileImg = profileImg.getBytes(StandardCharsets.UTF_8);
        else
            this.profileImg = null;
    }
}
