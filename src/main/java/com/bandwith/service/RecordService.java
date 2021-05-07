package com.bandwith.service;

import com.bandwith.dto.SearchRecordDto;
import com.bandwith.dto.record.RecordInsertDto;
import com.bandwith.dto.record.RecordNameDto;

import java.util.List;

public interface RecordService {
    RecordNameDto getRecordName(int recordId);
    void insertRecord(RecordInsertDto recordDto);
    void deleteRecord(int recordId);
    List<SearchRecordDto> getRecords(int musicId, String filter);
}
