package com.bandwith.dao;

import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.dto.band.BandInsertDto;
import com.bandwith.dto.record.RecordForBandDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("bandDaoBean")
public class BandDaoImpl implements BandDao {
    private final SqlSession sqlSession;

    @Autowired
    public BandDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int insertBand(BandInsertDto bandInsertDto) {
        return sqlSession.insert("BandMapper.insertBand", bandInsertDto);
    }

    @Override
    public int insertMemberBand(BandInsertDto bandInsertDto) {
        return sqlSession.insert("BandMapper.insertMemberBand", bandInsertDto);
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
    public Band selectBandByName(String bandName) {
        return sqlSession.selectOne("BandMapper.selectBandByName", bandName);
    }

    @Override
    public List<RecordForBandDto> findByBandName(int band_id) {
        return sqlSession.selectList("BandMapper.recordsByBandName", band_id);
    }

    @Override
    public List<Member> memberinBand(int band_id) {
        return sqlSession.selectList("BandMapper.memberinBand", band_id);
    }

    @Override
    public void invite(int bandId, int memberId) {
        Map<String, Object> params = new HashMap<>();
        params.put("bandId", bandId);
        params.put("memberId", memberId);
        params.put("auth", "member");
        sqlSession.insert("BandMapper.invite", params);
    }

    @Override
    public List<BandMusic> selectBandMusics(int band_id) {
        return sqlSession.selectList("BandMapper.selectBandMusics", band_id);
    }

    @Override
    public void deleteMember(String bandName, String username) {
        Map<String, String> params = new HashMap<>();
        params.put("bandName", bandName);
        params.put("username", username);

        sqlSession.delete("BandMapper.deleteMember", params);
    }

    public Band selectBandByBandMusicId(int bandMusicId){
        return sqlSession.selectOne("BandMapper.selectBandByBandMusicId", bandMusicId);
    }
}
