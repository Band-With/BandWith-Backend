package com.bandwith.dto.bookmark;

import com.bandwith.domain.Bookmark;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;

import java.sql.Timestamp;
import java.util.List;

public class BookmarkDto {
    private int bookmark_id;
    private String title;
    private Timestamp created_at;
    private List<MemberBasicDto> members;
    private MusicDto music;

    public BookmarkDto(){
    }

    public BookmarkDto(int bookmark_id, String title, Timestamp created_at, List<MemberBasicDto> members, MusicDto music) {
        this.bookmark_id = bookmark_id;
        this.title = title;
        this.created_at = created_at;
        this.members = members;
        this.music = music;
    }

    public static BookmarkDto of(Bookmark bookmark, List<MemberBasicDto> members, MusicDto music){
        return new BookmarkDto(bookmark.getBookmark_id(), bookmark.getTitle(), bookmark.getCreated_at(), members, music);
    }

    public String getTitle() {
        return title;
    }

    public int getBookmark_id() {
        return bookmark_id;
    }

    public void setBookmark_id(int bookmark_id) {
        this.bookmark_id = bookmark_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public List<MemberBasicDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberBasicDto> members) {
        this.members = members;
    }

    public MusicDto getMusic() {
        return music;
    }

    public void setMusic(MusicDto music) {
        this.music = music;
    }
}
