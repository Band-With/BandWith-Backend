package com.bandwith.service;

import com.bandwith.dao.MemberDao;
import com.bandwith.domain.Member;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.member.MemberProfileUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("memberServiceBean")
public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    public MemberServiceImpl(@Qualifier("memberDaoBean") MemberDao memberDao,
                             PasswordEncoder passwordEncoder) {
        this.memberDao = memberDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public MemberDto getMember(String username) {
        return MemberDto.of(memberDao.selectMember(username));
    }

    @Override
    public List<MemberBasicDto> getMembers(String username) {     // search
        List<Member> members = memberDao.selectUsersByUsername(username);
        return MemberBasicDto.of(members);
    }

    @Override
    public void signUp(MemberDto newMember) {
        Member member = Member.of(newMember);
        memberDao.insertMember(member);
    }

    @Override
    public MemberDto signIn(MemberDto memberDto){
        Member member = Member.of(memberDto);
        Member loginMember = memberDao.login(member);

        MemberDto loginMemberDto = null;
        if(loginMember != null && passwordEncoder.matches(member.getPwd(), loginMember.getPwd()))
            loginMemberDto = MemberDto.of(loginMember);
        return loginMemberDto;
    }

    @Override
    public String sendMail(String email){
        Random random=new Random();  //난수 생성을 위한 랜덤 클래스
        String key="";  //인증번호

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email); //스크립트에서 보낸 메일을 받을 사용자 이메일 주소
        //입력 키를 위한 코드
        for(int i =0; i<3;i++) {
            int index=random.nextInt(25)+65; //A~Z까지 랜덤 알파벳 생성
            key+=(char)index;
        }
        int numIndex=random.nextInt(9999)+1000; //4자리 랜덤 정수를 생성
        key+=numIndex;
        message.setSubject("인증번호 입력을 위한 메일 전송");
        message.setText("인증 번호 : "+key);

        mailSender.send(message);
        return key;
    }

    @Override
    public Boolean checkCode(String mail, String code, HttpSession session){
        if(session.getAttribute(mail).equals(code)) {
            session.removeAttribute(mail);
            return true;
        }
        return false;
    }

    @Override
    public void modifyProfile(MemberProfileUpdateDto memberProfileUpdateDto) {
        memberDao.updateProfile(memberProfileUpdateDto);
    }

    @Override
    public void modifyPw(int memberId, String pwd) {
        memberDao.updatePw(memberId, pwd);
    }


}
