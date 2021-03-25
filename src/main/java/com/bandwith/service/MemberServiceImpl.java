package com.bandwith.service;

import com.bandwith.dao.MemberDao;
import com.bandwith.domain.Member;
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

    public void signUp(String id, String pw, String fName, String lName, String profileImg) {
        Member member = new Member(id, pw, fName + lName, profileImg);
        memberDao.insertMember(member);
    }
}
