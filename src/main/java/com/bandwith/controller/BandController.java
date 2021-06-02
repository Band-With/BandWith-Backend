package com.bandwith.controller;

import com.bandwith.domain.Member;
import com.bandwith.dto.band.BandDetailDto;
import com.bandwith.dto.band.BandInsertDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.service.BandService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    public BandController(@Qualifier("bandServiceBean") BandService bandService) {
        this.bandService = bandService;
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
    public ResponseEntity<List<MemberBasicDto>> searchMusic(@RequestParam(value = "member_id") int member_id) {
        List<MemberBasicDto> memberBasicDtoList = bandService.searchUser(member_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberBasicDtoList);
    }


    @PostMapping("/invitation")
    public ResponseEntity invite(@RequestParam(value = "band_id") int band_id, @RequestParam(value = "member_id") int member_id) {

        try {
            bandService.invite(member_id, band_id);
            //밴드에 추가
            return ResponseEntity.status(HttpStatus.OK).body(null);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

}
