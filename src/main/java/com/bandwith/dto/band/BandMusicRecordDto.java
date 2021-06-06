package com.bandwith.dto.band;

import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;

public class BandMusicRecordDto {
    private MemberBasicDto member;
    private int recordId;
    private String fileUrl;

    public BandMusicRecordDto(MemberBasicDto member, int recordId, String fileUrl) {
        this.member = member;
        this.recordId = recordId;
        this.fileUrl = fileUrl;
    }

    public MemberBasicDto getMember() {
        return member;
    }

    public void setMember(MemberBasicDto member) {
        this.member = member;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
