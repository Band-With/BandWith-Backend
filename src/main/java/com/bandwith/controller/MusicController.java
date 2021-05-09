package com.bandwith.controller;

import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordDto;
import com.bandwith.service.MusicService;
import com.bandwith.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MusicController {
    private MusicService musicService;
    private RecordService recordService;

    @Autowired
    public MusicController(@Qualifier("musicServiceBean") MusicService musicService,@Qualifier("recordServiceBean") RecordService recordService){
        this.musicService = musicService;
        this.recordService = recordService;

    }

    @GetMapping("/musics")
    public ResponseEntity<List<MusicDto>> searchMusic(@RequestParam(value="q") String q, String filter, Model model) {

        List<MusicDto> musicList = musicService.search(q, filter);

        model.addAttribute("musicList",musicList);


        return ResponseEntity.status(HttpStatus.CREATED).body(musicList);
    }


}
