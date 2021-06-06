package com.bandwith.dto.member;

import com.bandwith.domain.Member;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MemberBasicDto {
    private int member_id;
    private String username;
    private String profile;

    public MemberBasicDto() {
    }

    public MemberBasicDto(int member_id, String username, String profile) {
        this.member_id = member_id;
        this.username = username;
        this.profile = profile;
    }

    public static MemberBasicDto of(Member member){
        String photo = null;
        if(member.getProfile_img() != null) {
            photo = new String(member.getProfile_img(), StandardCharsets.UTF_8);
            if( photo.startsWith("\uFEFF") ) {
                photo = photo.substring(1);
            }
        }

        return new MemberBasicDto(member.getMember_id(), member.getUsername(), photo);
    }

    public static List<MemberBasicDto> of (List<Member> members){
        List<MemberBasicDto> membersDto = new ArrayList<MemberBasicDto>();
        for(Member member: members)
            membersDto.add(MemberBasicDto.of(member));
        return membersDto;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
