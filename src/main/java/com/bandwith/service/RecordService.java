package com.bandwith.service;

import com.bandwith.dto.record.RecordCreateDto;
import com.bandwith.dto.record.RecordNameDto;

public interface RecordService {
    RecordNameDto getRecordName(int recordId);
    void uploadRecord(RecordCreateDto recordDto);
    void deleteRecord(int recordId);
}
