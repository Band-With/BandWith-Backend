package com.bandwith.service;

import com.bandwith.dao.RecordDao;
import com.bandwith.domain.Music;
import com.bandwith.domain.Record;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordDto;
import com.bandwith.dto.record.RecordNameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("recordServiceBean")
public class RecordServiceImpl implements RecordService {

    private RecordDao recordDao;

    @Autowired
    public RecordServiceImpl(@Qualifier("recordDaoBean") RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    @Override
    public RecordNameDto getRecordName(int recordId){
        return recordDao.getRecordName(recordId);
    }

    @Override
    public void uploadRecord(int musicId, int memberId, String instrument, boolean searchable, boolean access, String uuid, String fileName) {
        Record record = new Record(musicId, memberId, instrument, searchable, access, uuid, fileName);
        recordDao.insertRecord(record);
        System.out.println("upload record service");
    }

    @Override
    public void deleteRecord(int recordId) {
        recordDao.deleteRecord(recordId);
        System.out.println("delete record service");
    }


    @Override
    @Transactional
    public List<RecordDto> search(int music_id) {

        List<Record> records = recordDao.selectRecords(music_id);

        List<RecordDto> recordList = new ArrayList<>();

        if(records.isEmpty()) return recordList;

        for(Record record: records){
            recordList.add(this.convertEntityToDto(record));
        }

        return recordList;
    }

    private RecordDto convertEntityToDto(Record record) {
        return RecordDto.builder()
                .record_id(record.getRecordId())
                .music_id(record.getMusicId())
                .created_at(record.getCreatedAt())
                .searchable(record.getSearchable())
                .access(record.getAccess())
                .file_name(record.getFileName())
                .build();
    }

}
