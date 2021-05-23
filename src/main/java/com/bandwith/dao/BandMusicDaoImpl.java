package com.bandwith.dao;

import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import com.bandwith.dto.band.BandMusicInsertDto;
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
    public int insertBandMusic(BandMusicInsertDto bandMusicInsertDto) {
        return sqlSession.insert("BandMusicMapper.insertBandMusic", bandMusicInsertDto);
    }

    @Override
    public Music getMusic(int music_id) {
        return sqlSession.selectOne("BandMusicMapper.getMusic", music_id);
    }

    @Override
    public List<Member> recordMember(int band_music_id) {
        return sqlSession.selectList("BandMusicMapper.getRecordMember", band_music_id);
    }

}
