package com.bandwith.controller;

import com.bandwith.dto.CommentPageDto;
import com.bandwith.dto.band.BandMontlyDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.member.MemberMonthlyDto;
import com.bandwith.service.BookmarkService;
import com.bandwith.service.HomeService;
import com.bandwith.service.S3Service;
import com.bandwith.service.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MonthlyController {
    private ScheduledService scheduledService;

    @Autowired
    public MonthlyController(@Qualifier("scheduledService") ScheduledService scheduledService) {
        this.scheduledService = scheduledService;
    }

/*
    @GetMapping("/monthlyBand")
    public List<BandMontlyDto> monthlyBand(){
        return scheduledService.getBandResult();
    }

    @GetMapping("/monthlyMember")
    public List<MemberMonthlyDto> monthlyMember(){
    }
*/
}

