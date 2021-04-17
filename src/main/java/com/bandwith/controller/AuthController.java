package com.bandwith.controller;

import com.bandwith.dto.member.MemberDto;
import com.bandwith.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        int count = memberService.signIn(memberDto);

        if(count == 0)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);


        return ResponseEntity.status(HttpStatus.OK).body(memberDto);
    }
}
