package com.bandwith.controller;

import com.bandwith.service.AudioService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping("/mix")
    public void getTest() throws Exception {
        ArrayList<String> files = new ArrayList<>();

        files.add("https://bucket-band-with.s3.ap-northeast-2.amazonaws.com/records/dong_1.wav");
        files.add("https://bucket-band-with.s3.ap-northeast-2.amazonaws.com/records/dong_2.wav");
        files.add("https://bucket-band-with.s3.ap-northeast-2.amazonaws.com/records/sample2.wav");

        AudioService.mixTest(files);
    }
}
