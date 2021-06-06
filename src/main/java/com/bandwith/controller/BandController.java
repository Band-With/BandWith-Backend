package com.bandwith.controller;

import com.bandwith.domain.Member;
import com.bandwith.dto.band.BandDetailDto;
import com.bandwith.dto.band.BandInsertDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.service.BandService;
import com.bandwith.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class BandController {

    private BandService bandService;
    private MemberService memberService;

    @Autowired
    public BandController(@Qualifier("bandServiceBean") BandService bandService,
                          @Qualifier("memberServiceBean") MemberService memberService) {
        this.bandService = bandService;
        this.memberService = memberService;
    }

    @PostMapping("/bands")
    public ResponseEntity createBand(@RequestBody String filterJSON) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            BandInsertDto bandInsertDto = mapper.readValue(filterJSON, BandInsertDto.class);

            bandService.insertBand(bandInsertDto);

            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
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

    @PostMapping("/bands/{bandname}/members/{username}")
    public ResponseEntity leaveBand(@PathVariable("bandname") String bandName, @PathVariable String username) {
        try {
            bandService.leaveBand(bandName, username);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/members")
    public ResponseEntity searchUser(@RequestParam(value = "q") String username) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(memberService.getMembers(username));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("bands/{bandname}/invitation")
    public ResponseEntity invite(@PathVariable String bandname,
                                 @RequestBody JSONObject jsonObject) {
        try {
            String bandName = (String)jsonObject.get("bandName");
            int memberId = (int)jsonObject.get("memberId");

            bandService.invite(bandName, memberId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
