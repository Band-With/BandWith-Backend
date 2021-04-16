package com.bandwith.domain;
import java.sql.Timestamp;

public class Record {
    int recordId;
    int musicId;
    int memberId;
    String instrument;
    boolean searchable;
    boolean access;
    Timestamp createdAt;
    String uuid;
    String fileName;

    public Record(int recordId, int musicId, int memberId, String instrument, boolean searchable, boolean access, Timestamp createdAt, String uuid, String fileName) {
        this.recordId = recordId;
        this.musicId = musicId;
        this.memberId = memberId;
        this.instrument = instrument;
        this.searchable = searchable;
        this.access = access;
        this.createdAt = createdAt;
        this.uuid = uuid;
        this.fileName = fileName;
    }

    public Record(int musicId, int memberId, String instrument, boolean searchable, boolean access, String uuid, String fileName) {
        this.musicId = musicId;
        this.memberId = memberId;
        this.instrument = instrument;
        this.searchable = searchable;
        this.access = access;
        this.uuid = uuid;
        this.fileName = fileName;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
