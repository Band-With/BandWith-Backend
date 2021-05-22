package com.bandwith.dao;

import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.dto.band.BandMemberDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.record.RecordForBandDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    @Override
    public List<Member> searchUser(int band_id) {
        return sqlSession.selectList("BandMapper.searchUser", band_id);
    }

    @Override
    public void invite(int member_id, int band_id) {
        BandMemberDto member = new BandMemberDto(band_id,member_id,"");
        sqlSession.insert("BandMapper.invite", member);
    }

    @Override
    public List<BandMusic> selectBandMusics(int band_id) {
        return sqlSession.selectList("BandMapper.selectBandMusics", band_id);
    }
}
