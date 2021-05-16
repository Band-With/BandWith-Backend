package com.bandwith.service;

import com.bandwith.dto.member.MemberBasicDto;

import java.util.List;

public interface FollowService {
    void follow(String memberId, int followerId);
    void unfollow(String memberId, int followerId);
    List<MemberBasicDto> getFollowings(String memberId);
    List<MemberBasicDto> getFollowers(String memberId);
}
