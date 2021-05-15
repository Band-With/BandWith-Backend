package com.bandwith.dto.comment;

public class CommentCreateDto {
    private int bandMusicId;
    private String username;
    private int member_id;
    private int recordId;
    private String content;


    public CommentCreateDto(){}

    public CommentCreateDto(int bandMusicId, String username, int member_id, int recordId, String content) {
        this.bandMusicId = bandMusicId;
        this.username = username;
        this.member_id = member_id;
        this.recordId = recordId;
        this.content = content;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
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
