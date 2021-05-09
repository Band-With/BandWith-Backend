package com.bandwith.controller;

import com.bandwith.dto.member.MemberDto;
import com.bandwith.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Random;

@CrossOrigin
@RestController
public class AuthController {
    private MemberService memberService;

    @Autowired
    public AuthController(@Qualifier("memberServiceBean") MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<String> signUp(@RequestBody String filterJSON) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MemberDto newMember = mapper.readValue(filterJSON, MemberDto.class);
        memberService.signUp(newMember);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @PostMapping("/auth/signin")
    public ResponseEntity<MemberDto> signIn(@RequestBody String filterJSON) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MemberDto memberDto = mapper.readValue(filterJSON, MemberDto.class);
        MemberDto loginMember = memberService.signIn(memberDto);

        if(loginMember == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

        return ResponseEntity.status(HttpStatus.OK).body(loginMember);
    }

    @PostMapping("/auth/getCode") // AJAX와 URL을 매핑시켜줌
    @ResponseBody  //AJAX후 값을 리턴하기위해 작성
    public ResponseEntity<?> sendCode(HttpSession session, @RequestBody JSONObject filterJSON) {
        String mail = (String)filterJSON.get("mail");
        memberService.sendMail(mail, session);

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @PostMapping("/auth/checkCode")
    @ResponseBody
    public ResponseEntity<?> checkCode(HttpSession session, @RequestBody JSONObject filterJSON){
        String mail = (String)filterJSON.get("mail");
        String code = (String)filterJSON.get("code");

        if(memberService.checkCode(mail, code, session))
            return ResponseEntity.status(HttpStatus.OK).body("");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("");
    }
}
