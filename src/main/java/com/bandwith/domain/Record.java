package com.bandwith.domain;

import java.util.Date;

public class Record {
    private int record_id;
    private int music_id;
    private int member_id;
    private String instrument;
    private Boolean searchable;
    private Boolean access;
    private String uuid;
    private String file_name;
    private Date created_at;

    public Record(){}

    public Record(int record_id, int music_id, int member_id, String instrument, Boolean searchable, Boolean access, String uuid, String file_name, Date created_at) {
        this.record_id = record_id;
        this.music_id = music_id;
        this.member_id = member_id;
        this.instrument = instrument;
        this.searchable = searchable;
        this.access = access;
        this.uuid = uuid;
        this.file_name = file_name;
        this.created_at = created_at;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
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

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
