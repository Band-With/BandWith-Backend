package com.bandwith.service;

import com.bandwith.dao.RecordDao;
import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordNameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
