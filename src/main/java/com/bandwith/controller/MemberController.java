package com.bandwith.controller;

import com.bandwith.dto.member.MyPageDto;
import com.bandwith.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(@Qualifier("memberServiceBean") MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/myPage")
    public MyPageDto myPage(String username){
        return memberService.getMyPage(username);
    }

    @GetMapping("/testAPI")
    public int test(int param){
        return param * 2 + 2;
    }

    @RequestMapping(path="/")
    public String mainPage(){
        return "index";
    }
}
