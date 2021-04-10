package com.bandwith.dao;

import com.bandwith.domain.Record;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("recordDaoBean")
public class RecordDaoImpl implements RecordDao{
    private final SqlSession sqlSession;

    @Autowired
    public RecordDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Record> selectRecords(String username) {
        return sqlSession.selectList("RecordMapper.selectRecords", username);
    }
}
