package com.bandwith.controller;

import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.band.BandDetailDto;
import com.bandwith.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
public class BandController {

    private BandService bandService;
    private HttpSession session;

    @Autowired
    public BandController(@Qualifier("bandServiceBean") BandService bandService){
        this.bandService = bandService;
    }


   @GetMapping("/bands/{band_id}")
    public ResponseEntity<BandDetailDto> getBands(@PathVariable int band_id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bandService.getBand(band_id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

}
