package com.bandwith.controller;

import com.bandwith.dto.bookmark.BookmarkDto;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.PlaylistDto;
import com.bandwith.service.MemberService;
import com.bandwith.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class MemberController {
    private MemberService memberService;
    private MyPageService myPageService;

    @Autowired
    public MemberController(@Qualifier("memberServiceBean") MemberService memberService,
                            @Qualifier("recordServiceBean") MyPageService myPageService){
        this.memberService = memberService;
        this.myPageService = myPageService;
    }

    @GetMapping("/myPage")
    public ResponseEntity<MyPageDto> myPage(String username){
        MyPageDto myPageDto = myPageService.getMyPage(username);
        if (myPageDto == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(myPageDto);
    }

    @GetMapping("/record")
    public List<PlaylistDto> record(String username){
        return myPageService.getMyRecord(username);
    }

    @GetMapping("/bookmark")
    public List<BookmarkDto> bookmark(String username){
        return myPageService.getBookmarks(username);
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
