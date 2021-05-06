package com.bandwith.dto.record;

import com.bandwith.domain.Record;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class RecordDto {
    private int record_id;
    private int music_id;
    private int member_id;
    private String instrument;
    private Boolean searchable;
    private Boolean access;
    private Timestamp created_at;
    private String file_url; //modify to real file

    public RecordDto(int record_id, int music_id, int member_id, String instrument, Boolean searchable, Boolean access, Timestamp created_at, String file_url) {
        this.record_id = record_id;
        this.music_id = music_id;
        this.member_id = member_id;
        this.instrument = instrument;
        this.searchable = searchable;
        this.access = access;
        this.created_at = created_at;
        this.file_url = file_url;
    }

    public static RecordDto of(Record record) {
        return new RecordDto(
                record.getRecordId(),
                record.getMusicId(),
                record.getMemberId(),
                record.getInstrument(),
                record.isSearchable(),
                record.isAccess(),
                record.getCreatedAt(),
                record.getFileUrl());
    }

    public static List<RecordDto> of(List<Record> records) {
        List<RecordDto> recordsDto = new ArrayList();
        for (Record record : records)
            recordsDto.add(RecordDto.of(record));
        return recordsDto;
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
}
