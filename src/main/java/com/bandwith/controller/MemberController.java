package com.bandwith.controller;

import com.bandwith.dto.PracDetailDto;
import com.bandwith.dto.bookmark.BookmarkDto;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.service.MemberService;
import com.bandwith.service.MyPageService;
import com.bandwith.service.PracDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/members/{username}")
public class MemberController {
    private MemberService memberService;
    private MyPageService myPageService;
    private PracDetailService pracDetailService;

    @Autowired
    public MemberController(@Qualifier("memberServiceBean") MemberService memberService,
                            @Qualifier("myPageServiceBean") MyPageService myPageService,
                            @Qualifier("pracDetailServiceBean") PracDetailService pracDetailService){
        this.memberService = memberService;
        this.myPageService = myPageService;
        this.pracDetailService = pracDetailService;
    }

    @GetMapping("")
    public ResponseEntity<MyPageDto> myPage(@PathVariable String username){
        MyPageDto myPageDto = myPageService.getMyPage(username);
        if (myPageDto == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(myPageDto);
    }

    @GetMapping("/records")
    public List<MusicDto> record(@PathVariable String username, Boolean condition){
        return myPageService.getMyRecord(username, condition);
    }

    @GetMapping("/bookmarks")
    public List<BookmarkDto> bookmark(@PathVariable String username){
        return myPageService.getBookmarks(username);
    }

    @GetMapping("/records/{title}")
    public ResponseEntity<PracDetailDto> pracDetail(@PathVariable String username, @PathVariable String title, Boolean condition){
        PracDetailDto pracDetailDto = pracDetailService.getPracDetail(username, title, condition);

        if (pracDetailDto.getRecords().size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(pracDetailDto);
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
