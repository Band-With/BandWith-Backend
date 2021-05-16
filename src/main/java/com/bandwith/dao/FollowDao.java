package com.bandwith.dao;

import com.bandwith.domain.Member;
import com.bandwith.dto.like.LikeOnBandMusicDto;
import com.bandwith.dto.like.LikeOnRecordDto;

import java.util.HashMap;
import java.util.List;

public interface FollowDao {
    List<Member> getFollowings(int memberId);
    List<Member> getFollowers(int memberId);
    void follow(HashMap<String, Integer> params);
    void unfollow(HashMap<String, Integer> params);
}
