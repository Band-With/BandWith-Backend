package com.bandwith.service;

import com.bandwith.dao.MemberDao;
import com.bandwith.domain.Member;
import com.bandwith.dto.member.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("memberServiceBean")
public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao;

    @Autowired
    public MemberServiceImpl(@Qualifier("memberDaoBean") MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void signUp(MemberDto newMember) {
        Member member = Member.of(newMember);
        memberDao.insertMember(member);
    }

    public MemberDto signIn(MemberDto memberDto){
        Member member = Member.of(memberDto);
        Member loginMember = memberDao.login(member);

        MemberDto loginMemberDto = null;
        if(loginMember != null)
            loginMemberDto = MemberDto.of(loginMember);
        return loginMemberDto;
    }
}
