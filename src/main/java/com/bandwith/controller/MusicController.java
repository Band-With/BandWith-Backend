package com.bandwith.controller;

import com.bandwith.dto.music.MusicDto;
import com.bandwith.service.MusicService;
import com.bandwith.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
public class MusicController {
    private MusicService musicService;

    @Autowired
    public MusicController(@Qualifier("musicServiceBean") MusicService musicService,
                           @Qualifier("recordServiceBean") RecordService recordService){
        this.musicService = musicService;
    }

    @GetMapping("/musics")
    public ResponseEntity<List<MusicDto>> searchMusic(@RequestParam(value="q") String q,
                                                      @RequestParam(value="filter") String filter) {
        List<MusicDto> musicList = musicService.search(q, filter);
        return ResponseEntity.status(HttpStatus.CREATED).body(musicList);
    }

    @GetMapping("/musics/{musicId}")
    public ResponseEntity getMusic(@PathVariable int musicId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(musicService.getMusic(musicId));
    }
}
