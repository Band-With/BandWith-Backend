package com.bandwith.dao;

import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordInsertDto;
import com.bandwith.dto.record.RecordNameDto;

import java.util.HashMap;
import java.util.List;

public interface RecordDao {
    Record selectRecord(int recordId);
    List<String> selectRecordUrlsByIdList(List<Integer> recordIdList);
    List<Record> selectRecordsByMusicId(HashMap<String, Object> params);
    List<Record> selectRecordsByFilter(HashMap<String, Object> params);
    RecordNameDto getRecordName(int recordId);
    void insertRecord(RecordInsertDto recordDto);
    void deleteRecord(int recordId);
    void updateAttributes(HashMap<String, Object> params);

    int countInstrument(int memberId, String instrument);

    List<Record> selectRecordsById(int music_id);
    List<Record> selectRecordsByUserName(String username);
}
