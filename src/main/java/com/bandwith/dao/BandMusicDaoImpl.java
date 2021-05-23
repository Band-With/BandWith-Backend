package com.bandwith.dao;

import com.bandwith.domain.BandMusic;
import com.bandwith.dto.band.BandMusicInsertDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("bandMusicDaoBean")
public class BandMusicDaoImpl implements BandMusicDao {

    private final SqlSession sqlSession;

    @Autowired
    public BandMusicDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int insertBandMusic(BandMusicInsertDto bandMusicInsertDto) {
        return sqlSession.insert("BandMusicMapper.insertBandMusic", bandMusicInsertDto);
    }

    public BandMusic select(int bandMusicId){
        return sqlSession.selectOne("BandMusicMapper.select", bandMusicId);
    }
}
