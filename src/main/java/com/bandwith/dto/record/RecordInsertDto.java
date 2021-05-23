package com.bandwith.dto.record;

import com.bandwith.domain.Record;


public class RecordInsertDto {
    private int musicId;
    private int memberId;
    private String username;
    private String instrument;
    private Boolean searchable;
    private Boolean access;
    private String uuid;
    private String fileName;
    private String fileUrl;

    public RecordInsertDto() {

    }

    public RecordInsertDto(int musicId, int memberId, String username, String instrument, Boolean searchable, Boolean access, String uuid, String fileName, String fileUrl) {
        this.musicId = musicId;
        this.memberId = memberId;
        this.username = username;
        this.instrument = instrument;
        this.searchable = searchable;
        this.access = access;
        this.uuid = uuid;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
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

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }


}
