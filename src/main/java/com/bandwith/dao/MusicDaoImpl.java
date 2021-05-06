package com.bandwith.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bandwith.domain.Music;

import java.util.List;

@Repository("musicDaoBean")
public class MusicDaoImpl implements MusicDao {

    private final SqlSession sqlSession;

    @Autowired
    public MusicDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Music selectMusic(int music_id) {
        return sqlSession.selectOne("MusicMapper.selectMusic", music_id);
    }

    @Override
    public Music selectMusicByTitle(String title) {
        return sqlSession.selectOne("MusicMapper.selectMusicByTitle", title);
    }

    @Override
    public List<Music> selectMusicOthersPage(String username) {
        return sqlSession.selectList("MusicMapper.selectOthersPage", username);
    }

    @Override
    public List<Music> selectMusicMyPage(String username) {
        return sqlSession.selectList("MusicMapper.selectMyPage", username);
    }

    @Override
    public void insertMusic(Music music) {
        sqlSession.insert("MemberMapper.insertMusic", music);
    }

    @Override
    public void deleteMusic(Music music) {
        sqlSession.delete("MemberMapper.deleteMusic", music);
    }

    @Override
    public void searchMusic(Music music) {
        List<Music> list = sqlSession.selectList("music.selectList");
    }

}
