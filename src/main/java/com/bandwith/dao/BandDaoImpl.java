package com.bandwith.dao;

import com.bandwith.domain.Member;
import com.bandwith.dto.member.BandDto;
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

    public List<BandDto> selectBands(String username) {
        return sqlSession.selectList("BandMapper.selectBands", username);
    }
}
