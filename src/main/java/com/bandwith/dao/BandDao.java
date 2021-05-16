package com.bandwith.dao;

import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Record;
import com.bandwith.dto.record.RecordForBandDto;

import java.util.List;

public interface BandDao {
    List<Band> selectBands(String username);
    Band selectOne(int band_id);
    Band selectBandByName(String bandName);
    List<RecordForBandDto> findByBandName(int band_id);
    List<Member> memberinBand(int band_id);


}
