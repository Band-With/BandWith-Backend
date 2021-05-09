package com.bandwith.controller;

import com.bandwith.dto.music.MusicDto;
import com.bandwith.service.MusicService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class MusicController {
    private MusicService musicService;

    @Autowired
    public MusicController(@Qualifier("musicServiceBean") MusicService musicService){
        this.musicService = musicService;
    }

    @PostMapping("/musics/insert")
    public ResponseEntity<String> insertMusic(@RequestBody String filterJSON) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MusicDto newmusic = mapper.readValue(filterJSON, MusicDto.class);
        musicService.insertMusic(newmusic);
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @GetMapping("/musics/{musicId}")
    public ResponseEntity getMusic(@PathVariable int musicId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(musicService.getMusic(musicId));
    }
}
