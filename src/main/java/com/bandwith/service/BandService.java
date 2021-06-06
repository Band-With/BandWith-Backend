package com.bandwith.service;

import com.bandwith.domain.Member;
import com.bandwith.dto.band.BandDetailDto;
import com.bandwith.dto.band.BandInsertDto;
import com.bandwith.dto.member.MemberBasicDto;

import java.util.List;

public interface BandService {
    void insertBand(BandInsertDto bandInsertDto);
    BandDetailDto getBand(String bandname);
    void invite(String bandName, int memberId);
    void leaveBand(String bandName, String username);
}
