package com.bandwith.controller;

import com.bandwith.dto.band.BandMusicDto;
import com.bandwith.service.BandMusicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/bands/{bandname}/bandmusics")
public class BandMusicController {

    private BandMusicService bandMusicService;

    @Autowired
    public BandMusicController(@Qualifier("bandMusicServiceBean") BandMusicService bandMusicService){
        this.bandMusicService = bandMusicService;
    }

    // 밴드 합주곡 처음 등록
    @PostMapping("")
    public ResponseEntity createBandMusic(@RequestBody String filterJSON) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            BandMusicDto bandMusicDto = mapper.readValue(filterJSON, BandMusicDto.class);

            bandMusicService.createBandMusic(bandMusicDto);

            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // TODO 밴드 합주곡에 대해 각자의 녹음 등록
    @PostMapping("/{bandMusicId}/records")
    public ResponseEntity addBandMusicRecord() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getStackTrace());
        }
    }

    // TODO 밴드 합주곡에 대해 등록된 녹음 합쳐서 저장하기
    @PostMapping("/{bandMusicId}")
    public ResponseEntity completeBandMusic() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getStackTrace());
        }
    }

    // TODO 밴드 합주곡 삭제
    @DeleteMapping("/{bandMusicId}")
    public ResponseEntity deleteBandMusic() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getStackTrace());
        }
    }
}
