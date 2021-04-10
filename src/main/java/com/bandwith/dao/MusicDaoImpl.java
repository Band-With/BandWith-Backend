package com.bandwith.dao;

import com.bandwith.domain.Music;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("musicDaoBean")
public class MusicDaoImpl implements MusicDao{
    private final SqlSession sqlSession;

    @Autowired
    public MusicDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Music selectMusic(int record_id){
        return sqlSession.selectOne("MusicMapper.selectMusic", record_id);
    }
}
