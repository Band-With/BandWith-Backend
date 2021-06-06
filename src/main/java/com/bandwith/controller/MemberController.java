package com.bandwith.controller;

import com.bandwith.dto.PracDetailDto;
import com.bandwith.dto.bookmark.BookmarkDto;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.member.MemberDto;
import com.bandwith.dto.member.MemberProfileUpdateDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.List;

@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class MemberController {
    private MemberService memberService;
    private MyPageService myPageService;
    private PracDetailService pracDetailService;
    private FollowService followService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MemberController(@Qualifier("memberServiceBean") MemberService memberService,
                            @Qualifier("myPageServiceBean") MyPageService myPageService,
                            @Qualifier("pracDetailServiceBean") PracDetailService pracDetailService,
                            @Qualifier("followServiceBean") FollowService followService,
                            PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.myPageService = myPageService;
        this.pracDetailService = pracDetailService;
        this.followService = followService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/member/{username}")
    public ResponseEntity getMember(@PathVariable String username){
        try {
            MemberDto memberDto = memberService.getMember(username);
            if (memberDto == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.status(HttpStatus.OK).body(memberDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/members/{username}")
    public ResponseEntity<MyPageDto> myPage(@PathVariable String username){
        MyPageDto myPageDto = myPageService.getMyPage(username);
        if (myPageDto == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(myPageDto);
    }

    @GetMapping("/members/{username}/records")
    public ResponseEntity<List<MusicDto>> record(@PathVariable String username, Boolean condition){
        return ResponseEntity.status(HttpStatus.OK).body(myPageService.getMyRecord(username, condition));
    }

    @GetMapping("/members/{username}/bookmarks")
    public ResponseEntity<List<BookmarkDto>> bookmark(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(myPageService.getBookmarks(username));
    }

    @GetMapping("/members/{username}/records/{musicId}")
    public ResponseEntity<PracDetailDto> pracDetail(@PathVariable String username, @PathVariable int musicId, Boolean condition){
        PracDetailDto pracDetailDto = pracDetailService.getPracDetail(username, musicId, condition);

        if (pracDetailDto.getRecords().size() == 0)
            return ResponseEntity.status(HttpStatus.OK).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(pracDetailDto);
    }

    @PatchMapping("/members/{username}/records/{recordId}")
    public ResponseEntity<?> patchRecordAttribute(@PathVariable int recordId, @RequestBody JSONObject jsonObject){
        Boolean access = (Boolean)jsonObject.get("access");
        Boolean searchable = (Boolean)jsonObject.get("searchable");
        pracDetailService.patchRecordAttributes(recordId, access, searchable);
        return ResponseEntity.ok("resource patched");
    }

    @GetMapping("/members/{username}/followings")
    public ResponseEntity<List<MemberBasicDto>> getFollowings(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(followService.getFollowings(username));
    }

    @GetMapping("/members/{username}/followers")
    public ResponseEntity<List<MemberBasicDto>> getFollowers(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(followService.getFollowers(username));
    }

    @DeleteMapping("/members/{username}/follows")
    public ResponseEntity unfollow(@PathVariable String username, @RequestBody JSONObject jsonObject){
        int followingId = (int)jsonObject.get("followingId");
        followService.unfollow(username, followingId);
        return ResponseEntity.ok("");
    }

    @PostMapping("/members/{username}/follows")
    public ResponseEntity follow(@PathVariable String username, @RequestBody JSONObject jsonObject){
        int followingId = (int)jsonObject.get("followingId");
        followService.follow(username, followingId);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PatchMapping("/members/{memberId}")
    public ResponseEntity modifyMemberProfile(@PathVariable int memberId,
                                              @RequestBody String filterJSON) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            MemberProfileUpdateDto dto = mapper.readValue(filterJSON, MemberProfileUpdateDto.class);

            memberService.modifyProfile(dto);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping("/members/{memberId}/pw")
    public ResponseEntity modifyMemberPw(@PathVariable int memberId, HttpSession session,
                                         @RequestBody JSONObject jsonObject){
        try {
            PrivateKey privateKey = (PrivateKey) session.getAttribute("RSA_PRIVATE_KEY");

            String encryptPwd = (String)jsonObject.get("pwd");
            String pwd = decryptRsa(privateKey, encryptPwd);

            memberService.modifyPw(memberId, passwordEncoder.encode(pwd));
            return ResponseEntity.ok("");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public String decryptRsa(PrivateKey privateKey, String securedValue) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
        String decryptedValue = "";

        Cipher cipher = Cipher.getInstance("RSA");

        byte[] encryptedBytes = hexToByteArray(securedValue);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        decryptedValue = new String(decryptedBytes, "utf-8");

        return decryptedValue;
    }

    public static byte[] hexToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
