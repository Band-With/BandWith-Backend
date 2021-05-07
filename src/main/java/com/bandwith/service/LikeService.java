package com.bandwith.service;

import com.bandwith.dto.like.LikeOnBandMusicDto;
import com.bandwith.dto.like.LikeOnRecordDto;

public interface LikeService {
    void insertLikeOnRecord(LikeOnRecordDto likeOnRecordDto);
    void insertLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto);
    void deleteLikeOnRecord(LikeOnRecordDto likeOnRecordDto);
    void deleteLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto);
}
