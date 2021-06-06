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
import java.util.Map;

@Repository("recordDaoBean")
public class RecordDaoImpl implements RecordDao {
    private final SqlSession sqlSession;

    @Autowired
    public RecordDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Record selectRecord(int recordId) {
        return sqlSession.selectOne("RecordMapper.select", recordId);
    }

    @Override
    public RecordNameDto getRecordName(int recordId) {
        return sqlSession.selectOne("RecordMapper.getRecordName", recordId);
    }

    @Override
    public List<Record> selectRecordsById(int music_id) {
        return sqlSession.selectList("RecordMapper.selectByMusicId", music_id);
    }

    @Override
    public List<String> selectRecordUrlsByIdList(List<Integer> recordIdList) {
        Map<String, Object> param = new HashMap<>();
        param.put("recordIdList", recordIdList);
        return sqlSession.selectList("RecordMapper.selectRecordUrlsByIdList", param);
    }

    @Override
    public List<Record> selectRecordsByUserName(String username) {
        return sqlSession.selectList("RecordMapper.selectRecords", username);
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
    public void insertRecord(RecordInsertDto recordDto) {
        sqlSession.insert("RecordMapper.insertRecord", recordDto);
    }

    @Override
    public void deleteRecord(int recordId) {
        sqlSession.delete("RecordMapper.deleteRecord", recordId);
    }

    @Override
    public void updateAttributes(HashMap<String, Object> params) {
        sqlSession.update("RecordMapper.updateAttributes", params);
    }

    @Override
    public int countInstrument(int memberId, String instrument) {
        Map<String, Object> param = new HashMap<>();
        param.put("memberId", memberId);
        param.put("instrument", instrument);
        return sqlSession.selectOne("RecordMapper.countInstrument", param);
    }

    public List<Record> selectRecordByBandMusicId(int bandMusicId) {
        return sqlSession.selectList("RecordMapper.selectRecordsByBandMusicId", bandMusicId);
    }
}
