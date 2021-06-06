package com.bandwith.dao;

import com.bandwith.domain.BandMusic;
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

    public BandMusic select(int bandMusicId){
        return sqlSession.selectOne("BandMusicMapper.select", bandMusicId);
    }

    @Override
    public Music getMusic(int music_id) {
        return sqlSession.selectOne("BandMusicMapper.getMusic", music_id);
    }

    @Override
    public List<Member> recordMember(int band_music_id) {
        return sqlSession.selectList("BandMusicMapper.getRecordMember", band_music_id);
    }

    public List<BandMusic> searchBandMusicTitle(String title) {
        return sqlSession.selectList("BandMusicMapper.selectBandMusicTitle", title);
    }

    public List<BandMusic> searchBandMusicLike(String title) {
        return sqlSession.selectList("BandMusicMapper.selectBandMusicLike", title);
    }

    public List<BandMusic> searchBandMusicBandTitle(String title){
        return sqlSession.selectList("BandMusicMapper.selectBandMusicBandTitle", title);
    }

    public List<BandMusic> searchBandMusicBandLike(String title){
        return sqlSession.selectList("BandMusicMapper.selectBandMusicBandLike", title);
    }
}
