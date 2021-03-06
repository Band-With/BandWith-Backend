package com.bandwith.service;


import com.bandwith.dao.*;
import com.bandwith.domain.*;
import com.bandwith.domain.Record;
import com.bandwith.dto.MyPageDto;
import com.bandwith.dto.band.*;
import com.bandwith.dto.bookmark.BookmarkInsertDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.dao.BandDao;
import com.bandwith.dao.MemberDao;
import com.bandwith.domain.Band;
import com.bandwith.domain.Member;
import com.bandwith.dto.band.BandDetailDto;
import com.bandwith.dto.band.BandInsertDto;
import com.bandwith.dto.record.RecordForBandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("bandServiceBean")
public class
BandServiceImpl implements BandService {

    private MusicDao musicDao;
    private BandDao bandDao;
    private LikeDao likeDao;
    private BandMusicDao bandMusicDao;
    private CommentDao commentDao;
    private MemberDao memberDao;

    @Autowired
    public BandServiceImpl(@Qualifier("musicDaoBean") MusicDao musicDao,
                           @Qualifier("bandDaoBean") BandDao bandDao,
                           @Qualifier("memberDaoBean") MemberDao memberDao,
                           @Qualifier("likeDaoBean") LikeDao likeDao,
                           @Qualifier("bandMusicDaoBean") BandMusicDao bandMusicDao,
                           @Qualifier("commentDaoBean") CommentDao commentDao) {
        this.musicDao = musicDao;
        this.bandDao = bandDao;
        this.likeDao = likeDao;
        this.bandMusicDao = bandMusicDao;
        this.commentDao = commentDao;
        this.memberDao = memberDao;
    }

    @Override
    public void insertBand(BandInsertDto bandInsertDto) {
        // band 생성
        bandDao.insertBand(bandInsertDto);
        
        // member name -> id
        Member member = memberDao.selectMemberWithUsername(bandInsertDto.getUsername());
        bandInsertDto.setMemberId(member.getMember_id());
        
        // member_band 생성
        bandDao.insertMemberBand(bandInsertDto);
    }

    @Override
    public BandDetailDto getBand(String bandname) {
        //BandGetDto 완성
        Band band_ = bandDao.selectBandByName(bandname);
        if (band_==null)
            return null;
        BandGetDto band = BandGetDto.of(band_);

        int band_id = band.getBand_id();
        //Band의 멤버
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
            //밴드 뮤직 리스트 안의, i번째 밴드 뮤직에서 music ID를 가져와서 bandmusicdao.getmusic을 이용해 music table 검색
            MusicDto musicDto = MusicDto.of(musicDao.selectMusic(bandMusicList.get(i).getMusicId()));
            musics.add(musicDto);
        }
        //BandMusic의 Dto만듬
        List<BandDetailMusicDto> bandMusicDtoList = new ArrayList<BandDetailMusicDto>();
        // Band Music에 대한 Member를 가져옴
        List<List<Member>> bandMusicMember = new ArrayList<List<Member>>();
        for (int i=0; i<bandMusicList.size(); i++){
            bandMusicMember.add(bandMusicDao.recordMember(bandMusicList.get(i).getBandMusicId()));
        }

        List<List<MemberBasicDto>> recordMemberDtos = new ArrayList<List<MemberBasicDto>>();
        for(int i=0; i<musics.size(); i++){
            recordMemberDtos.add(MemberBasicDto.of(bandMusicMember.get(i)));
        }

        List<Integer> likes= new ArrayList<Integer>();
        for(int i=0; i< musics.size(); i++) {
            likes.add(likeDao.bandMusicLike(bandMusicList.get(i).getMusicId()));
        }
        List<Integer> comments= new ArrayList<Integer>();
        for(int i=0; i< musics.size(); i++) {
            comments.add(commentDao.bandMusicComments(bandMusicList.get(i).getMusicId()));
        }

  

        for(int i=0; i<musics.size(); i++){
           // BandMusic bandMusic, MusicDto musicDto, List<MemberBasicDto> membe    rBasicDtoList, int likes, int comments
            BandDetailMusicDto bandMusicDto = BandDetailMusicDto.of(bandMusicList.get(i), musics.get(i), recordMemberDtos.get(i), likes.get(i),comments.get(i));
            bandMusicDtoList.add(bandMusicDto);
        }
        int totalLikes=0;

        for(int i=0; i<likes.size(); i++){
            totalLikes+=likes.get(i);
        }

//int band_music_id, Timestamp complete_date, Boolean complete, MusicDto musicDto, List<MemberBasicDto> memberBasicDtoList, int likes, int comments
        BandDetailDto bandDetailDto= new BandDetailDto(band, memberBasicDtos, bandMusicDtoList, totalLikes);

        return bandDetailDto;
    }

    @Override
    public void invite(String bandName, int memberId) {
        Band band = bandDao.selectBandByName(bandName);
        bandDao.invite(band.getBand_id(), memberId);
    }

    public void leaveBand(String bandName, String username){
        bandDao.deleteMember(bandName, username);
    }
}
