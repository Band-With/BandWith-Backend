package com.bandwith.domain;

import java.util.Date;

public class Bookmark {
    private int bookmark_id;
    private int member_id;
    private Date created_at;
    private int music_id;
    private String title;

    public Bookmark(int bookmark_id, int member_id, Date created_at, int music_id, String title) {
        this.bookmark_id = bookmark_id;
        this.member_id = member_id;
        this.created_at = created_at;
        this.music_id = music_id;
        this.title = title;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
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
}
