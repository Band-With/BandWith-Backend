package com.bandwith.dao;

import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordForBandDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bandDaoBean")
public class BandDaoImpl implements BandDao{
    private final SqlSession sqlSession;

    @Autowired
    public BandDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Band> selectBands(String username) {
        return sqlSession.selectList("BandMapper.selectBands", username);
    }

    @Override
    public Band selectOne(int band_id) {
        return sqlSession.selectOne("BandMapper.selectOne", band_id);
    }

    @Override
    public List<RecordForBandDto> findByBandName(int band_id) {
        return sqlSession.selectList("BandMapper.recordsByBandName", band_id);
    }

    @Override
    public List<Member> memberinBand(int band_id) {
        return sqlSession.selectList("BandMapper.memberinBand", band_id);
    }
}
