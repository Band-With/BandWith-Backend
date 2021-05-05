package com.bandwith.dao;

import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordInsertDto;
import com.bandwith.dto.record.RecordNameDto;

import java.util.HashMap;
import java.util.List;

public interface RecordDao {
    List<Record> selectRecords(String username);
    List<Record> selectRecordsByTitle(HashMap<String, Object> params);
    RecordNameDto getRecordName(int recordId);
    void insertRecord(RecordInsertDto recordDto);
    void deleteRecord(int recordId);
    void updateAttributes(HashMap<String, Object> params);
}
