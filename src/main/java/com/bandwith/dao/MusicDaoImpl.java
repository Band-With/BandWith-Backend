package com.bandwith.dao;

import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("musicDaoBean")
public class MusicDaoImpl implements MusicDao {

    private final SqlSession sqlSession;

    @Autowired
    public MusicDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
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
