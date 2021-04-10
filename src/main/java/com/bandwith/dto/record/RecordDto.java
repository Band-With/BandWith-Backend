package com.bandwith.dto.record;

import com.bandwith.domain.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordDto {
    private int record_id;
    private int music_id;
    private Boolean searchable;
    private Boolean access;
    private String file_name; //modify to real file

    public RecordDto(int record_id, int music_id, Boolean searchable, Boolean access, String file_name) {
        this.record_id = record_id;
        this.music_id = music_id;
        this.searchable = searchable;
        this.access = access;
        this.file_name = file_name;
    }

    public static RecordDto of(Record record){
        return new RecordDto(record.getRecord_id(), record.getMusic_id(), record.getSearchable(), record.getAccess(), record.getFile_name());
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

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}
