package com.bandwith.service;

import com.bandwith.dao.BandDao;
import com.bandwith.dao.MemberDao;
import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.dto.band.BandDto;
import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.MyPageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberServiceBean")
public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao;

    @Autowired
    public MemberServiceImpl(@Qualifier("memberDaoBean") MemberDao memberDao) {
        this.memberDao = memberDao;
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
}
