package com.bandwith.service;

import com.bandwith.dto.record.RecordDto;
import com.bandwith.dto.record.RecordNameDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecordService {
    RecordNameDto getRecordName(int recordId);
    void uploadRecord(int musicId, int memberId, String instrument, boolean searchable, boolean access, String uuid, String fileName);
    void deleteRecord(int recordId);


    @Transactional
    List<RecordDto> search(int music_id);
}
