package com.bandwith.dao;

import com.bandwith.domain.Member;
import com.bandwith.dto.member.BandDto;

import java.util.List;

public interface BandDao {
    List<BandDto> selectBands(String username);
}
