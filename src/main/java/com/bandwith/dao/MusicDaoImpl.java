package com.bandwith.dao;

import com.bandwith.domain.Music;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("musicDaoBean")
public class MusicDaoImpl implements MusicDao{
    private final SqlSession sqlSession;

    @Autowired
    public MusicDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Music selectMusic(int music_id){
        return sqlSession.selectOne("MusicMapper.selectMusic", music_id);
    }
    public List<Music> selectMusicOthersPage(String username) {
        return sqlSession.selectList("MusicMapper.selectOthersPage", username);
    }
    public List<Music> selectMusicMyPage(String username) {
        return sqlSession.selectList("MusicMapper.selectMyPage", username);}
}
