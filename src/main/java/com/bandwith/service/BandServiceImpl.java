package com.bandwith.service;


import com.bandwith.dao.*;
import com.bandwith.domain.*;
import com.bandwith.domain.Record;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.band.*;
import com.bandwith.dto.bookmark.BookmarkInsertDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordForBandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("bandServiceBean")
public class BandServiceImpl implements BandService {

    private BandDao bandDao;
    private LikeDao likeDao;
    private BandMusicDao bandMusicDao;

    @Autowired
    public BandServiceImpl(@Qualifier("bandDaoBean") BandDao bandDao, @Qualifier("likeDaoBean") LikeDao likeDao, @Qualifier("bandMusicDaoBean") BandMusicDao bandMusicDao) {
        this.bandDao = bandDao;
        this.likeDao = likeDao;

    }

    @Override
    public BandDetailDto getBand(int band_id) {
        //BandGetDto 완성
        Band band = bandDao.selectOne(band_id);
        BandGetDto bandGetDto = BandGetDto.of(band);
        //Band의 멤버 가져와서 MeberBasicDto List 생성함
        List<Member> members = bandDao.memberinBand(band_id);
        List<MemberBasicDto> memberBasicDtos = new ArrayList<MemberBasicDto>();
        for(int i=0; i<members.size(); i++){
            MemberBasicDto memberBasicDto = MemberBasicDto.of(members.get(i));
            memberBasicDtos.add(memberBasicDto);
        }

        //BandMusic의 List를 가져옴
        List<BandMusic> bandMusicList= bandDao.selectBandMusics(band_id);
        //BandMusic의 List의 id값들을 이용해서 MusicDto의 List 만듬
        List<MusicDto> musics =  new ArrayList<MusicDto>();
        for(int i=0; i<bandMusicList.size(); i++){
            MusicDto musicDto = MusicDto.of(bandMusicDao.getMusic(bandMusicList.get(i).getBandMusicId()));
            musics.add(musicDto);
        }
        //BandMusic의 Dto만듬
        List<BandMusicDto> bandMusicDtoList = new ArrayList<BandMusicDto>();
        // Band Music에 대한 Member를 가져옴
        List<List<Member>> recordMember = new ArrayList<List<Member>>();
        for (int i=0; i<bandMusicList.size(); i++){
            recordMember.add(bandMusicDao.recordMember(bandMusicList.get(i).getBandMusicId()));
        }

        List<List<MemberBasicDto>> recordMemberDtos = new ArrayList<List<MemberBasicDto>>();
        for(int i=0; i<members.size(); i++){
            recordMemberDtos.add(MemberBasicDto.of(recordMember.get(i)));
        }

        for(int i=0; i<members.size(); i++){
//BandMusic bandMusic, MusicDto musicDto, List<MemberBasicDto> memberBasicDtoList, int likes, int comments
            BandMusicDto bandMusicDto = BandMusicDto.of(bandMusicList.get(i), musics.get(i), recordMemberDtos.get(i), 0, 0);
            bandMusicDtoList.add(bandMusicDto);
        }
        int totalLikes=1;

        BandDetailDto bandDetailDto= new BandDetailDto(bandGetDto, memberBasicDtos, bandMusicDtoList, totalLikes);
        return bandDetailDto;
    }

    @Override
    public List<MemberBasicDto> searchUser(int member_id) {
        List<Member> members = bandDao.searchUser(member_id);
        List<MemberBasicDto> memberdtos = new ArrayList<MemberBasicDto>();
        for(int i=0; i<members.size(); i++){
            MemberBasicDto memberBasicDto = MemberBasicDto.of(members.get(i));
            memberdtos.add(memberBasicDto);
        }

        return memberdtos;
    }

    @Override
    public void invite(int member_id,int band_id) {
        bandDao.invite(member_id, band_id);
    }


}
