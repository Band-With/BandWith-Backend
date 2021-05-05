package com.bandwith.dto.record;

import com.bandwith.domain.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordInsertDto {
    private int memberId;
    private int musicId;
    private String instrument;
    private Boolean searchable;
    private Boolean access;
    private String uuid;
    private String fileName;

    public RecordInsertDto(int memberId, int musicId, String instrument, Boolean searchable, Boolean access, String uuid, String fileName) {
        this.memberId = memberId;
        this.musicId = musicId;
        this.instrument = instrument;
        this.searchable = searchable;
        this.access = access;
        this.uuid = uuid;
        this.fileName = fileName;
    }

    public static RecordInsertDto of(Record record){
        return new RecordInsertDto(
                record.getMemberId(),
                record.getMusicId(),
                record.getInstrument(),
                record.getSearchable(),
                record.getAccess(),
                record.getUuid(),
                record.getFileName());
    }

    public static List<RecordInsertDto> of(List<Record> records){
        List<RecordInsertDto> recordsDto = new ArrayList();
        for(Record record: records)
            recordsDto.add(RecordInsertDto.of(record));
        return recordsDto;
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
}
