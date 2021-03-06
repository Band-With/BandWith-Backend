package com.bandwith.dao;

import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.domain.Record;
import com.bandwith.dto.band.BandInsertDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.record.RecordForBandDto;

import java.util.List;

public interface BandDao {
    int insertBand(BandInsertDto bandInsertDto);
    int insertMemberBand(BandInsertDto bandInsertDto);

    List<Band> selectBands(String username);
    Band selectOne(int band_id);
    Band selectBandByName(String bandName);
    List<RecordForBandDto> findByBandName(int band_id);
    List<Member> memberinBand(int band_id);
    void invite(int bandId, int memberId);
    List<BandMusic> selectBandMusics(int band_id);
    void deleteMember(String bandName, String username);
    Band selectBandByBandMusicId(int bandMusicId);
}
