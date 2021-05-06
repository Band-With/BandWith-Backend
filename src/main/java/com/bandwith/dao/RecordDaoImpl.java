package com.bandwith.dao;

import com.bandwith.domain.Music;
import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordNameDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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

    public RecordNameDto getRecordName(int recordId) {
        return sqlSession.selectOne("RecordMapper.getRecordName", recordId);
    }

    public void insertRecord(Record record) {
        sqlSession.insert("RecordMapper.insertRecord", record);
    }

    public void deleteRecord(int recordId) {
        sqlSession.delete("RecordMapper.deleteRecord", recordId);
    }

    public List<Record> selectRecordsByTitle(HashMap<String, Object> params) {
        return sqlSession.selectList("RecordMapper.selectRecordsByTitle", params);
    }

    public void updateAttributes(HashMap<String, Object> params){
        sqlSession.update("RecordMapper.updateAttributes", params);
    }

    @Override
    public List<Record> selectRecords(int music_id) {
        List<Record> list = sqlSession.selectList("RecordMapper.selectByMusicId", music_id);

        return list;
    }
}
