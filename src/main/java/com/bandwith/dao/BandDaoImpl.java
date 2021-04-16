package com.bandwith.dao;

import com.bandwith.domain.Band;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bandDaoBean")
public class BandDaoImpl implements BandDao{
    private final SqlSession sqlSession;

    @Autowired
    public BandDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Band> selectBands(String username) {
        return sqlSession.selectList("BandMapper.selectBands", username);
    }
}