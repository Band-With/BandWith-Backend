package com.bandwith.controller;

import com.bandwith.dto.bandMusic.BandMusicDetailDto;
import com.bandwith.dto.bandMusic.BandMusicInsertDto;
import com.bandwith.dto.bandMusic.BandMusicUpdateDto;
import com.bandwith.service.AudioService;
import com.bandwith.dto.MixDetailDto;
import com.bandwith.service.BandMusicService;
import com.bandwith.service.S3Service;
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
public class BandMusicController {

    private BandMusicService bandMusicService;
    private S3Service s3Service;

    @Autowired
    public BandMusicController(@Qualifier("bandMusicServiceBean") BandMusicService bandMusicService,
                               @Qualifier("s3Service") S3Service s3Service) {
        this.bandMusicService = bandMusicService;
        this.s3Service = s3Service;
    }

    // 밴드 합주곡 가져오기
    @GetMapping("/bands/{bandname}/bandmusics/{band_music_id}")
    public ResponseEntity<BandMusicDetailDto> getBandMusic(@PathVariable("band_music_id") int bandMusicId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bandMusicService.getBandMusic(bandMusicId));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 밴드 합주곡 처음 등록
    @PostMapping("/bands/{bandname}/bandmusics")
    public ResponseEntity insertBandMusic(@RequestBody String filterJSON) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            BandMusicInsertDto bandMusicInsertDto = mapper.readValue(filterJSON, BandMusicInsertDto.class);

            bandMusicService.insertBandMusic(bandMusicInsertDto);

            return ResponseEntity.status(HttpStatus.OK).body("Insert Band Music");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/bands/{bandname}/bandmusics/{bandMusicId}/records")
    public ResponseEntity<MixDetailDto> getBandMusicRecords(@PathVariable("bandname") String bandName,
                                                         @PathVariable int bandMusicId){
        return ResponseEntity.status(HttpStatus.OK).body(bandMusicService.getBandMusicRecords(bandName, bandMusicId));
    }

    // 밴드 합주곡에 대해 각자의 녹음 등록
    @PostMapping("/bands/{bandname}/bandmusics/{bandMusicId}/records")
    public ResponseEntity addBandMusicRecord(@PathVariable int bandMusicId, @RequestBody JSONObject filterJSON) {
        try {
            int recordId = (int)filterJSON.get("recordId");
            bandMusicService.insertRecordBandMusic(bandMusicId, recordId);

            return ResponseEntity.status(HttpStatus.OK).body("Add Record to Band Music");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // 밴드 합주곡에 대해 등록된 녹음 합쳐서 저장
    @PostMapping("/bands/{bandname}/bandmusics/{bandMusicId}")
    public ResponseEntity completeBandMusic(@PathVariable int bandMusicId) {
        try {
            byte[] bandMusic = AudioService.mixAudioFiles(bandMusicService.getRecordUrls(bandMusicId));

            String uploadPath = "bandmusics/";
            String[] fileInfo = s3Service.uploadFile(uploadPath, "bandmusic" + bandMusicId, bandMusic); // {uuid, fileName, key}
            String url = s3Service.getFileURL(fileInfo[2]);

            BandMusicUpdateDto bandMusicUpdateDto = new BandMusicUpdateDto(bandMusicId, true, fileInfo[0], fileInfo[1], url);
            bandMusicService.updateComplete(bandMusicUpdateDto);

            return ResponseEntity.status(HttpStatus.OK).body("Complete Band Music");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    // 밴드 합주곡 삭제
    @DeleteMapping("/bands/{bandname}/bandmusics/{bandMusicId}")
    public ResponseEntity deleteBandMusic(@PathVariable int bandMusicId) {
        try {
            bandMusicService.deleteBandMusic(bandMusicId);
            return ResponseEntity.status(HttpStatus.OK).body("Delete Band Music");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
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
