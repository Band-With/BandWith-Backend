package com.bandwith.service;

import com.bandwith.dto.record.RecordNameDto;

public interface RecordService {
    RecordNameDto getRecordName(int recordId);
    void uploadRecord(int musicId, int memberId, String instrument, boolean searchable, boolean access, String uuid, String fileName);
    void deleteRecord(int recordId);
}
