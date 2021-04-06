package com.bandwith.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
@RestController
public class TestController {
    @GetMapping("/permit-all")
    public Object getTest() throws Exception {
        return "good";
    }

    @GetMapping("/auth")
    public Object getTest2() throws Exception {
        return "bad";
    }

}
