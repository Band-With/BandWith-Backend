package com.bandwith.service;

import com.bandwith.domain.Member;
import com.bandwith.dto.band.BandDetailDto;
import com.bandwith.dto.band.BandInsertDto;

import java.util.List;

public interface BandService {
    void insertBand(BandInsertDto bandInsertDto);
    BandDetailDto getBand(int band_id);
    List<Member> searchUser(int member_id);
    void invite(int member_id, int band_id);
}
