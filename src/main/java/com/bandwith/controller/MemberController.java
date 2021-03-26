package com.bandwith.controller;

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

    @GetMapping("/testAPI")
    public int test(int param){
        return param * 2 + 2;
    }

    @RequestMapping(path="/")
    public String mainPage(){
        return "index";
    }

    @RequestMapping(path="/join")
    public String join(String id, String pw, String fName, String lName, String profileImg) {
        if(id != null && !id.equals("")) {
            memberService.signUp(id, pw, fName, lName, profileImg);
            return "login";
        }

        return "join";
    }
}
