package com.bandwith.dao;

import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.domain.RecordBandMusic;
import com.bandwith.dto.bandMusic.BandMusicUpdateDto;
import com.bandwith.dto.bandMusic.BandMusicInsertDto;
import com.bandwith.dto.bandMusic.RecordBandMusicDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("bandMusicDaoBean")
public class BandMusicDaoImpl implements BandMusicDao {

    private final SqlSession sqlSession;

    @Autowired
    public BandMusicDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
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
    public int insertBandMusic(BandMusicInsertDto bandMusicInsertDto) {
        return sqlSession.insert("BandMusicMapper.insertBandMusic", bandMusicInsertDto);
    }

    @Override
    public int insertRecordBandMusic(RecordBandMusicDto recordBandMusicDto) {
        return sqlSession.insert("BandMusicMapper.insertRecordBandMusic", recordBandMusicDto);
    }

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

    public void deleteBandMusicRecord(int bandMusicId, int recordId){
        Map<String, Integer> params = new HashMap<>();
        params.put("bandMusicId", bandMusicId);
        params.put("recordId", recordId);
        sqlSession.delete("BandMusicMapper.deleteBandMusicRecord", params);
    }
}
