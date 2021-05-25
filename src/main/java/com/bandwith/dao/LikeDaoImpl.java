package com.bandwith.dao;

import com.bandwith.dto.like.LikeOnBandMusicDto;
import com.bandwith.dto.like.LikeOnRecordDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("likeDaoBean")
public class LikeDaoImpl implements LikeDao{

    private SqlSession sqlSession;

    @Autowired
    public LikeDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int countLike(int record_id){
        return sqlSession.selectOne("LikeMapper.countLike", record_id);
    }

    @Override
    public int bandMusicLike(int band_music_id) {
        if(sqlSession.selectOne("LikeMapper.bandMusicLike", band_music_id)!=null){
            return sqlSession.selectOne("LikeMapper.bandMusicLike", band_music_id);

        }else{
            return 0;
        }

    }

    @Override
    public void insertLikeOnRecord(LikeOnRecordDto likeOnRecordDto) {
        sqlSession.insert("LikeMapper.insertLikeOnRecord", likeOnRecordDto);
    }

    @Override
    public void insertLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto) {
        sqlSession.insert("LikeMapper.insertLikeOnBandMusic", likeOnBandMusicDto);
    }

    @Override
    public void deleteLikeOnRecord(LikeOnRecordDto likeOnRecordDto) {
        sqlSession.delete("LikeMapper.deleteLikeOnRecord", likeOnRecordDto);
    }

    @Override
    public void deleteLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto) {
        sqlSession.delete("LikeMapper.deleteLikeOnBandMusic", likeOnBandMusicDto);
    }
}
