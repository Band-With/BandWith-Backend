package com.bandwith.dto.bookmark;

public class BookmarkInsertDto {
    private int bookmarkId;
    private int memberId;
    private int musicId;
    private String title;
    private int[] members;
    private String fileUrl;

    public BookmarkInsertDto() {

    }

    public BookmarkInsertDto(int bookmarkId, int memberId, int musicId, String title, int[] members, String fileUrl) {
        this.bookmarkId = bookmarkId;
        this.memberId = memberId;
        this.musicId = musicId;
        this.title = title;
        this.members = members;
        this.fileUrl = fileUrl;
    }

    public int getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(int bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int[] getMembers() {
        return members;
    }

    public void setMembers(int[] members) {
        this.members = members;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
