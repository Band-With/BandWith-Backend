package com.bandwith.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Record {

    private int recordId;
    private int musicId;
    private int memberId;
    private String instrument;
    private boolean searchable;
    private boolean access;
    private Timestamp createdAt;
    private String uuid;
    private String fileName;
    private String fileUrl;

    public Record(int recordId, int musicId, int memberId, String instrument, boolean searchable, boolean access, Timestamp createdAt, String uuid, String fileName, String fileUrl) {
        this.recordId = recordId;
        this.musicId = musicId;
        this.memberId = memberId;
        this.instrument = instrument;
        this.searchable = searchable;
        this.access = access;
        this.createdAt = createdAt;
        this.uuid = uuid;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
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

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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
