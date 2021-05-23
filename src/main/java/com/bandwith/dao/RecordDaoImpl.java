package com.bandwith.dao;

import com.bandwith.domain.Music;
import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordInsertDto;
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



    @Override
    public RecordNameDto getRecordName(int recordId) {
        return sqlSession.selectOne("RecordMapper.getRecordName", recordId);
    }

    @Override
    public void insertRecord(RecordInsertDto recordDto) {
        sqlSession.insert("RecordMapper.insertRecord", recordDto);
    }

    @Override
    public void deleteRecord(int recordId) {
        sqlSession.delete("RecordMapper.deleteRecord", recordId);
    }

    @Override
    public List<Record> selectRecordsByMusicId(HashMap<String, Object> params) {
        return sqlSession.selectList("RecordMapper.selectRecordsByMusicId", params);
    }

    @Override
    public List<Record> selectRecordsByFilter(HashMap<String, Object> params) {
        return sqlSession.selectList("RecordMapper.selectRecordsByFilter", params);
    }

    @Override
    public void updateAttributes(HashMap<String, Object> params){
        sqlSession.update("RecordMapper.updateAttributes", params);
    }

    @Override
    public List<Record> selectRecordsById(int music_id) {
        List<Record> list = sqlSession.selectList("RecordMapper.selectByMusicId", music_id);

        return list;
    }
    @Override
    public List<Record> selectRecordsByUserName(String username) {
        return sqlSession.selectList("RecordMapper.selectRecords", username);
    }

}
