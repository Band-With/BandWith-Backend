package com.bandwith.dao;

import com.bandwith.dto.like.LikeOnBandMusicDto;
import com.bandwith.dto.like.LikeOnRecordDto;

public interface LikeDao {
    int countLike(int record_id);
    int bandMusicLike(int band_music_id);

    void insertLikeOnRecord(LikeOnRecordDto likeOnRecordDto);
    void insertLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto);
    void deleteLikeOnRecord(LikeOnRecordDto likeOnRecordDto);
    void deleteLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto);
}
