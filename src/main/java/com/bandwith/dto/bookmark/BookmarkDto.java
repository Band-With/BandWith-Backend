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
    private String file_url;
    private List<MemberBasicDto> members;
    private MusicDto music;

    public BookmarkDto() {
    }

    public BookmarkDto(int bookmark_id, String title, Timestamp created_at, String file_url, List<MemberBasicDto> members, MusicDto music) {
        this.bookmark_id = bookmark_id;
        this.title = title;
        this.created_at = created_at;
        this.file_url = file_url;
        this.members = members;
        this.music = music;
    }

    public static BookmarkDto of(Bookmark bookmark, List<MemberBasicDto> members, MusicDto music) {
        return new BookmarkDto(
                bookmark.getBookmark_id(),
                bookmark.getTitle(),
                bookmark.getCreated_at(),
                bookmark.getFile_url(),
                members,
                music);
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

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
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
