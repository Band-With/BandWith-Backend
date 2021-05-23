package com.bandwith.controller;

import com.bandwith.domain.Member;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.band.BandDetailDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordNameDto;
import com.bandwith.service.BandService;
import com.bandwith.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@RestController
public class BandController {

    private BandService bandService;
    private HttpSession session;

    @Autowired
    public BandController(@Qualifier("bandServiceBean") BandService bandService){
        this.bandService = bandService;
    }


   @GetMapping("/bands/{bandname}")
    public ResponseEntity<BandDetailDto> getBands(@PathVariable String bandname) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bandService.getBand(bandname));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

    @GetMapping("/members")
    public ResponseEntity<List<MemberBasicDto>> searchMember(@RequestParam(value="member_id") int member_id) {
        List<MemberBasicDto> memberBasicDtoList = bandService.searchUser(member_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberBasicDtoList);
    }


    @PostMapping("/invitation")
    public ResponseEntity invite(@RequestParam(value="band_id") int band_id,@RequestParam(value="member_id") int member_id) {

        try {
            bandService.invite(member_id,band_id);
            //밴드에 추가
            return ResponseEntity.status(HttpStatus.OK).body(null);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
