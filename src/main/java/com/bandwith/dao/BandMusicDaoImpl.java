package com.bandwith.dao;

import com.bandwith.domain.Band;
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
    public Band insertBandMusic(BandMusicDao bandMusicDao) {
        return sqlSession.selectOne("BandMusicMapper.insertBandMusic", bandMusicDao);
    }
}
