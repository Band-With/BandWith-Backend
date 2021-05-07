package com.bandwith.domain;

import java.sql.Timestamp;

public class Bookmark {
    private int bookmark_id;
    private int member_id;
    private Timestamp created_at;
    private int music_id;
    private String title;
    private String file_url;

    public Bookmark(int bookmark_id, int member_id, Timestamp created_at, int music_id, String title, String file_url) {
        this.bookmark_id = bookmark_id;
        this.member_id = member_id;
        this.created_at = created_at;
        this.music_id = music_id;
        this.title = title;
        this.file_url = file_url;
    }

    public int getBookmark_id() {
        return bookmark_id;
    }

    public void setBookmark_id(int bookmark_id) {
        this.bookmark_id = bookmark_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }
}
