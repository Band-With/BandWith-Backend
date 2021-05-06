package com.bandwith.service;

import com.bandwith.dao.BookmarkDao;
import com.bandwith.dao.LikeDao;
import com.bandwith.dto.like.LikeOnBandMusicDto;
import com.bandwith.dto.like.LikeOnRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("likeServiceBean")
public class LikeServiceImpl implements LikeService {

    LikeDao likeDao;

    @Autowired
    public LikeServiceImpl(@Qualifier("likeDaoBean") LikeDao likeDao) {
        this.likeDao = likeDao;
    }

    @Override
    public void insertLikeOnRecord(LikeOnRecordDto likeOnRecordDto) {
        likeDao.insertLikeOnRecord(likeOnRecordDto);
    }

    @Override
    public void insertLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto) {
        likeDao.insertLikeOnBandMusic(likeOnBandMusicDto);
    }

    @Override
    public void deleteLikeOnRecord(LikeOnRecordDto likeOnRecordDto) {
        likeDao.deleteLikeOnRecord(likeOnRecordDto);
    }

    @Override
    public void deleteLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto) {
        likeDao.deleteLikeOnBandMusic(likeOnBandMusicDto);
    }
}
