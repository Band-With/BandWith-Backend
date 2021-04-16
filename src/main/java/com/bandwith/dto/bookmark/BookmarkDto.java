package com.bandwith.dto.bookmark;

import com.bandwith.domain.Bookmark;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;

import java.util.Date;
import java.util.List;

public class BookmarkDto {
    private String title;
    private Date created_at;
    private List<MemberBasicDto> members;
    private MusicDto music;

    public BookmarkDto(){
    }

    public BookmarkDto(String title, Date created_at, List<MemberBasicDto> members, MusicDto music) {
        this.title = title;
        this.created_at = created_at;
        this.members = members;
        this.music = music;
    }

    public static BookmarkDto of(Bookmark bookmark, List<MemberBasicDto> members, MusicDto music){
        return new BookmarkDto(bookmark.getTitle(), bookmark.getCreated_at(), members, music);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
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
