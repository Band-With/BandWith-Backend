package com.bandwith.service;

import com.bandwith.dao.FollowDao;
import com.bandwith.dao.MemberDao;
import com.bandwith.domain.Member;
import com.bandwith.dto.member.MemberBasicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("followServiceBean")
public class FollowServiceImpl implements FollowService{
    private FollowDao followDao;
    private MemberDao memberDao;


    @Autowired
    public FollowServiceImpl(@Qualifier("followDaoBean") FollowDao followDao,
                             @Qualifier("memberDaoBean") MemberDao memberDao) {
        this.followDao = followDao;
        this.memberDao = memberDao;
    }

    @Override
    public void follow(String username, int followingId) {
        HashMap<String, Integer> params = new HashMap<>();
        int memberId = memberDao.getMemberIdOf(username);
        params.put("followingId", followingId);
        params.put("followerId", memberId);
        followDao.follow(params);
    }

    @Override
    public void unfollow(String username, int followingId) {
        HashMap<String, Integer> params = new HashMap<>();
        int memberId = memberDao.getMemberIdOf(username);
        params.put("followingId", followingId);
        params.put("followerId", memberId);
        followDao.unfollow(params);
    }

    @Override
    public List<MemberBasicDto> getFollowings(String username) {
        int memberId = memberDao.getMemberIdOf(username);
        List<Member> memberList = followDao.getFollowings(memberId);
        List<MemberBasicDto> memberDtoList = MemberBasicDto.of(memberList);
        return memberDtoList;
    }

    @Override
    public List<MemberBasicDto> getFollowers(String username) {
        int memberId = memberDao.getMemberIdOf(username);
        List<Member> memberList = followDao.getFollowers(memberId);
        List<MemberBasicDto> memberDtoList = MemberBasicDto.of(memberList);
        return memberDtoList;
    }
}
