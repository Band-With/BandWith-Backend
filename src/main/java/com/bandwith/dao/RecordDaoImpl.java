package com.bandwith.dao;

import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordNameDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("recordDaoBean")
public class RecordDaoImpl implements RecordDao {

    private final SqlSession sqlSession;

    @Autowired
    public RecordDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public RecordNameDto getRecordName(int recordId) {
        return sqlSession.selectOne("RecordMapper.getRecordName", recordId);
    }

    @Override
    public void insertRecord(Record record) {
        sqlSession.insert("RecordMapper.insertRecord", record);
    }

    @Override
    public void deleteRecord(int recordId) {
        sqlSession.delete("RecordMapper.deleteRecord", recordId);
    }
}
