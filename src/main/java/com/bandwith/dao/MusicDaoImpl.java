package com.bandwith.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import org.apache.ibatis.session.ResultHandler;
import java.util.List;
import com.bandwith.domain.Music;

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
    public Music selectMusicByTitle(String title){
        return sqlSession.selectOne("MusicMapper.selectMusicByTitle", title);
    }

    public List<Music> selectMusicOthersPage(String username) {
        return sqlSession.selectList("MusicMapper.selectOthersPage", username);
    }

    public List<Music> selectMusicMyPage(String username) {
        return sqlSession.selectList("MusicMapper.selectMyPage", username);}

    @Override
    public void insertMusic(Music music) {

    }

    @Override
    public void deleteMusic(Music music) {
        sqlSession.delete("MemberMapper.deleteMusic", music);
    }


    @Override
    public List<Music> searchMusic(String title) {
        List<Music> list = sqlSession.selectList("MusicMapper.selectMusicByTitle", title);

        return list;
    }

}
