package com.bandwith.dto.band;

import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;

public class BandMusicRecordDto {
    private MemberBasicDto member;
    private String fileUrl;

    public BandMusicRecordDto(MemberBasicDto member, String fileUrl) {
        this.member = member;
        this.fileUrl = fileUrl;
    }

    public MemberBasicDto getMember() {
        return member;
    }

    public void setMember(MemberBasicDto member) {
        this.member = member;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
