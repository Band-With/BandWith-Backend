package com.bandwith.controller;

import com.amazonaws.Response;
import com.bandwith.dto.CommentPageDto;
import com.bandwith.dto.PracDetailDto;
import com.bandwith.dto.bookmark.BookmarkDto;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.comment.CommentDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.service.CommentService;
import com.bandwith.service.MemberService;
import com.bandwith.service.MyPageService;
import com.bandwith.service.PracDetailService;
import org.json.simple.JSONObject;
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
    private CommentService commentService;

    @Autowired
    public MemberController(@Qualifier("memberServiceBean") MemberService memberService,
                            @Qualifier("myPageServiceBean") MyPageService myPageService,
                            @Qualifier("pracDetailServiceBean") PracDetailService pracDetailService,
                            @Qualifier("commentServiceBean") CommentService commentService){
        this.memberService = memberService;
        this.myPageService = myPageService;
        this.pracDetailService = pracDetailService;
        this.commentService = commentService;
    }

    @GetMapping("")
    public ResponseEntity<MyPageDto> myPage(@PathVariable String username){
        MyPageDto myPageDto = myPageService.getMyPage(username);
        if (myPageDto == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(myPageDto);
    }

    @GetMapping("/records")
    public ResponseEntity<List<MusicDto>> record(@PathVariable String username, Boolean condition){
        return ResponseEntity.status(HttpStatus.OK).body(myPageService.getMyRecord(username, condition));
    }

    @GetMapping("/bookmarks")
    public ResponseEntity<List<BookmarkDto>> bookmark(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(myPageService.getBookmarks(username));
    }

    @GetMapping("/records/{title}")
    public ResponseEntity<PracDetailDto> pracDetail(@PathVariable String username, @PathVariable String title, Boolean condition){
        PracDetailDto pracDetailDto = pracDetailService.getPracDetail(username, title, condition);

        if (pracDetailDto.getRecords().size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(pracDetailDto);
    }

    @GetMapping("/records/{recordId}/comments")
    public ResponseEntity<List<CommentPageDto>> getRecordComments(@PathVariable int recordId){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getRecordComments(recordId));
    }

    @PatchMapping("/records/{recordId}")
    public ResponseEntity<?> patchRecordAttribute(@PathVariable int recordId, @RequestBody JSONObject jsonObject){
        Boolean access = (Boolean)jsonObject.get("access");
        Boolean searchable = (Boolean)jsonObject.get("searchable");
        pracDetailService.patchRecordAttributes(recordId, access, searchable);
        return ResponseEntity.ok("resource patched");
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
