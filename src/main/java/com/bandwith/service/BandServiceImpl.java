package com.bandwith.service;


import com.bandwith.dao.BandDao;
import com.bandwith.dao.BookmarkDao;
import com.bandwith.dao.MemberDao;
import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import com.bandwith.domain.Record;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.band.BandDetailDto;
import com.bandwith.dto.band.BandDto;
import com.bandwith.dto.band.BandMemberDto;
import com.bandwith.dto.bookmark.BookmarkInsertDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordForBandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("bandServiceBean")
public class BandServiceImpl implements BandService {

    private BandDao bandDao;

    @Autowired
    public BandServiceImpl(@Qualifier("bandDaoBean") BandDao bandDao) {
        this.bandDao = bandDao;

    }

    @Override
    public BandDetailDto getBand(int band_id) {
        Band band = bandDao.selectOne(band_id);
        List<Member> members = bandDao.memberinBand(band_id);
        List<RecordForBandDto> records = bandDao.findByBandName(band_id);
        BandDetailDto bandDetailDto= new BandDetailDto(band, members, records);
        return bandDetailDto;
    }

    @Override
    public List<Member> searchUser(int member_id) {
        List<Member> members = bandDao.searchUser(member_id);
        return members;
    }

    @Override
    public void invite(int member_id,int band_id) {
        bandDao.invite(member_id, band_id);
    }


}
