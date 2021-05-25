package com.bandwith.domain;

import java.sql.Timestamp;

public class Comment {
    private int comment_id;
    private Integer band_music_id;
    private int member_id;
    private Integer record_id;
    private String content;
    private Timestamp created_at;
    private Boolean updated;

    public Comment(int comment_id, Integer band_music_id, int member_id, Integer record_id, String content, Timestamp created_at, Boolean updated) {
        this.comment_id = comment_id;
        this.band_music_id = band_music_id;
        this.member_id = member_id;
        this.record_id = record_id;
        this.content = content;
        this.created_at = created_at;
        this.updated = updated;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getBand_music_id() {
        return band_music_id;
    }

    public void setBand_music_id(Integer band_music_id) {
        this.band_music_id = band_music_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Boolean getUpdated() {
        return updated;
    }

    public void setUpdated(Boolean updated) {
        this.updated = updated;
    }
}
