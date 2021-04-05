package com.bandwith.dao;

import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordNameDto;

public interface RecordDao {
    RecordNameDto getRecordName(int recordId);
    void insertRecord(Record record);
    void deleteRecord(int recordId);
}
