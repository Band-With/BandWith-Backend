package com.bandwith.controller;

import com.bandwith.service.BookmarkService;
import com.bandwith.service.HomeService;
import com.bandwith.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HomeController {
    private HomeService homeService;

    @Autowired
    public HomeController(@Qualifier("homeServiceBean") HomeService homeService) {
        this.homeService = homeService;
    }


    @PatchMapping("/monthly-member")
    public void mothlyMember(){
        System.out.println("hi bitches");
        homeService.testScheduler();

    }

}

