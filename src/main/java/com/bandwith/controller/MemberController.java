package com.bandwith.controller;

import com.bandwith.dto.bookmark.BookmarkDto;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.PlaylistDto;
import com.bandwith.service.BookmarkService;
import com.bandwith.service.MemberService;
import com.bandwith.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class MemberController {
    private MemberService memberService;
    private RecordService recordService;
    private BookmarkService bookmarkService;

    @Autowired
    public MemberController(@Qualifier("memberServiceBean") MemberService memberService,
                            @Qualifier("recordServiceBean") RecordService recordService,
                            @Qualifier("bookmarkServiceBean") BookmarkService bookmarkService){
        this.memberService = memberService;
        this.recordService = recordService;
        this.bookmarkService = bookmarkService;
    }

    @GetMapping("/myPage")
    public MyPageDto myPage(String username){
        return memberService.getMyPage(username);
    }

    @GetMapping("/record")
    public List<PlaylistDto> record(String username){
        return recordService.getMyRecord(username);
    }

    @GetMapping("/bookmark")
    public BookmarkDto bookmark(String username){
        return bookmarkService.getBookmarks(username);
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
