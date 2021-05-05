package com.bandwith.service;

import com.bandwith.dto.record.RecordInsertDto;
import com.bandwith.dto.record.RecordNameDto;

public interface RecordService {
    RecordNameDto getRecordName(int recordId);
    void uploadRecord(RecordInsertDto recordDto);
    void deleteRecord(int recordId);
}
