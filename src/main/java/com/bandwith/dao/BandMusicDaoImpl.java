package com.bandwith.dao;

import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public Music getMusic(int band_music_id) {
        return null;
    }

    @Override
    public List<Member> recordMember(int band_id) {
        return null;
    }

}
