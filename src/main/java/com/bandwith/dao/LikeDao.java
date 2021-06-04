package com.bandwith.dao;

import com.bandwith.dto.band.BandMontlyDto;
import com.bandwith.dto.like.LikeOnBandMusicDto;
import com.bandwith.dto.like.LikeOnRecordDto;
import com.bandwith.dto.member.MemberMonthlyDto;

import java.util.List;

public interface LikeDao {
    int countLike(int record_id);
    int bandMusicLike(int band_music_id);

    void insertLikeOnRecord(LikeOnRecordDto likeOnRecordDto);
    void insertLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto);
    void deleteLikeOnRecord(LikeOnRecordDto likeOnRecordDto);
    void deleteLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto);

    List<BandMontlyDto> monthlyBand();
    List<MemberMonthlyDto> monthlyMember();

}
