package com.bandwith.dao;

import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordCreateDto;
import com.bandwith.dto.record.RecordNameDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("recordDaoBean")
public class RecordDaoImpl implements RecordDao {
    private final SqlSession sqlSession;

    @Autowired
    public RecordDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Record> selectRecords(String username) {
        return sqlSession.selectList("RecordMapper.selectRecords", username);
    }

    @Override
    public RecordNameDto getRecordName(int recordId) {
        return sqlSession.selectOne("RecordMapper.getRecordName", recordId);
    }

    @Override
    public void insertRecord(RecordCreateDto recordDto) {
        sqlSession.insert("RecordMapper.insertRecord", recordDto);
    }

    @Override
    public void deleteRecord(int recordId) {
        sqlSession.delete("RecordMapper.deleteRecord", recordId);
    }
}
