package com.bandwith.dao;

import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.domain.RecordBandMusic;
import com.bandwith.dto.bandMusic.BandMusicUpdateDto;
import com.bandwith.dto.bandMusic.BandMusicInsertDto;
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
    public BandMusic select(int bandMusicId){
        return sqlSession.selectOne("BandMusicMapper.select", bandMusicId);
    }

    @Override
    public List<Integer> selectRecordBandMusic(int bandMusicId) {
        return sqlSession.selectList("BandMusicMapper.selectRecordBandMusic", bandMusicId);
    }

//    @Override
//    public Music getMusic(int music_id) {
//        return sqlSession.selectOne("BandMusicMapper.getMusic", music_id);
//    }

    @Override
    public void updateComplete(BandMusicUpdateDto bandMusicUpdateDto) {
        sqlSession.update("BandMusicMapper.updateComplete", bandMusicUpdateDto);
    }

    @Override
    public void deleteBandMusic(int bandMusicId) {
        sqlSession.delete("BandMusicMapper.deleteBandMusic", bandMusicId);
    }

    @Override
    public List<Member> recordMember(int band_music_id) {
        return sqlSession.selectList("BandMusicMapper.getRecordMember", band_music_id);
    }
}
