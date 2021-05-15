package com.bandwith.dto.comment;

public class CommentCreateDto {
    private int bandMusicId;
    private String username;
    private int memberId;
    private int recordId;
    private String content;


    public CommentCreateDto(){}

    public CommentCreateDto(int bandMusicId, String username, int memberId, int recordId, String content) {
        this.bandMusicId = bandMusicId;
        this.username = username;
        this.memberId = memberId;
        this.recordId = recordId;
        this.content = content;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getBandMusicId() {
        return bandMusicId;
    }

    public void setBandMusicId(int bandMusicId) {
        this.bandMusicId = bandMusicId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
