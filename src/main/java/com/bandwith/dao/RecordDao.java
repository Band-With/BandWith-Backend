package com.bandwith.dao;

import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordCreateDto;
import com.bandwith.dto.record.RecordNameDto;
import java.util.List;

public interface RecordDao {
    List<Record> selectRecords(String username);
    RecordNameDto getRecordName(int recordId);
    void insertRecord(RecordCreateDto recordDto);
    void deleteRecord(int recordId);
}
