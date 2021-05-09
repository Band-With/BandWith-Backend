package com.bandwith.dto.bookmark;

public class BookmarkInsertDto {
    private int bookmarkId;
    private int memberId;
    private String username;
    private int musicId;
    private String title;
    private String fileUrl;

    private int[] members;
    private String[] recordUrls;

    public BookmarkInsertDto() {

    }

    public BookmarkInsertDto(int bookmarkId, int memberId, String username, int musicId, String title, String fileUrl, int[] members, String[] recordUrls) {
        this.bookmarkId = bookmarkId;
        this.memberId = memberId;
        this.username = username;
        this.musicId = musicId;
        this.title = title;
        this.fileUrl = fileUrl;
        this.members = members;
        this.recordUrls = recordUrls;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public int[] getMembers() {
        return members;
    }

    public void setMembers(int[] members) {
        this.members = members;
    }

    public String[] getRecordUrls() {
        return recordUrls;
    }

    public void setRecordUrls(String[] recordUrls) {
        this.recordUrls = recordUrls;
    }
}
