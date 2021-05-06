package com.bandwith.dto.record;

import com.bandwith.domain.Record;
import com.bandwith.dto.music.MusicDto;
import lombok.Builder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RecordDto {
    private int record_id;
    private int music_id;
    private Timestamp created_at;
    private Boolean searchable;
    private Boolean access;
    private String file_name; //modify to real file

    @Builder
    public RecordDto(int record_id, int music_id, Boolean searchable, Boolean access, Timestamp created_at, String file_name) {
        this.record_id = record_id;
        this.music_id = music_id;
        this.searchable = searchable;
        this.access = access;
        this.created_at = created_at;
        this.file_name = file_name;
    }

    public static RecordDto of(Record record){
        return new RecordDto(record.getRecordId(), record.getMusicId(), record.getSearchable(), record.getAccess(),
                record.getCreatedAt(), record.getFileName());
    }

    public static List<RecordDto> of(List<Record> records){
        List<RecordDto> recordsDto = new ArrayList<RecordDto>();
        for(Record record: records)
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

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}
