package com.bandwith.controller;

import com.amazonaws.services.dynamodbv2.xspec.L;
import com.bandwith.dto.band.BandMusicDetailDto;
import com.bandwith.dto.band.BandMusicInsertDto;
import com.bandwith.service.BandMusicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class BandMusicController {

    private BandMusicService bandMusicService;

    @Autowired
    public BandMusicController(@Qualifier("bandMusicServiceBean") BandMusicService bandMusicService){
        this.bandMusicService = bandMusicService;
    }

    // 밴드 합주곡 처음 등록
    @PostMapping("/bands/{bandname}/bandmusics")
    public ResponseEntity createBandMusic(@RequestBody String filterJSON) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            BandMusicInsertDto bandMusicInsertDto = mapper.readValue(filterJSON, BandMusicInsertDto.class);

            bandMusicService.createBandMusic(bandMusicInsertDto);

            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // TODO 밴드 합주곡에 대해 각자의 녹음 등록
    @PostMapping("/bands/{bandname}/bandmusics/{bandMusicId}/records")
    public ResponseEntity addBandMusicRecord() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getStackTrace());
        }
    }



    @GetMapping("/bands/{bandname}/bandmusics/{band_music_id}")
    public ResponseEntity<BandMusicDetailDto> getBandMusic(@PathVariable("band_music_id") int bandMusicId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bandMusicService.getBandMusic(bandMusicId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // TODO 밴드 합주곡에 대해 등록된 녹음 합쳐서 저장하기
    @PostMapping("/bands/{bandname}/bandmusics/{bandMusicId}")
    public ResponseEntity completeBandMusic() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getStackTrace());
        }
    }

    // TODO 밴드 합주곡 삭제
    @DeleteMapping("/bands/{bandname}/bandmusics/{bandMusicId}")
    public ResponseEntity deleteBandMusic() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getStackTrace());
        }
    }

    @GetMapping("/bandmusics")
    public ResponseEntity<List<BandMusicDetailDto>> searchBandMusic(@RequestParam(value="title") String bandMusicTitle,
                                                                   @RequestParam(value="filter") String filter,
                                                                    @RequestParam(value="subject") String subject){
        try {
            List<BandMusicDetailDto> bandMusicDtoList = bandMusicService.searchBandMusic(bandMusicTitle, filter, subject);
            return ResponseEntity.status(HttpStatus.OK).body(bandMusicDtoList);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
