package com.bandwith.dto.comment;

public class CommentCreateDto {
    private Integer bandMusicId;
    private String username;
    private int memberId;
    private Integer recordId;
    private String content;


    public CommentCreateDto(){}

    public CommentCreateDto(Integer bandMusicId, String username, int memberId, Integer recordId, String content) {
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

    public Integer getBandMusicId() {
        return bandMusicId;
    }

    public void setBandMusicId(Integer bandMusicId) {
        this.bandMusicId = bandMusicId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
