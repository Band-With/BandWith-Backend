package com.bandwith.service;

import com.bandwith.dao.BandDao;
import com.bandwith.dao.MemberDao;
import com.bandwith.domain.Member;
import com.bandwith.dto.member.BandDto;
import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.member.MyPageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberServiceBean")
public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao;
    private BandDao bandDao;

    @Autowired
    public MemberServiceImpl(@Qualifier("memberDaoBean") MemberDao memberDao,
                             @Qualifier("bandDaoBean") BandDao bandDao) {
        this.memberDao = memberDao;
        this.bandDao = bandDao;
    }

    public void signUp(MemberDto newMember) {
/*        if(newMember.getProfileImg() == null)
            newMember.setProfileImg();*/
        Member member = Member.of(newMember, "www.test.com");
        memberDao.insertMember(member);
    }

    public int signIn(Member member){
        int count = memberDao.login(member);
        return count;
    }

    public MyPageDto getMyPage(String username){
        List<BandDto> newBands = bandDao.selectBands(username);
        int followers = memberDao.countFollower(username);
        int followings = memberDao.countFollowing(username);

        System.out.println(newBands);

        MyPageDto myPageDto = new MyPageDto(followers, followings, newBands);

        return myPageDto;
    }
}
