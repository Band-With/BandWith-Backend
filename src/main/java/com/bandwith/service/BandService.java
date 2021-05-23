package com.bandwith.service;

import com.bandwith.domain.Member;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.band.BandDetailDto;
import com.bandwith.dto.member.MemberBasicDto;

import java.util.List;

public interface BandService {

    BandDetailDto getBand(String bandname);
    List<MemberBasicDto> searchUser(int member_id);
    void invite(int member_id, int band_id);

}
