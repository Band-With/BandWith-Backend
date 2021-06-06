package com.bandwith.dao;

import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.dto.band.BandMontlyDto;
import com.bandwith.dto.like.LikeOnBandMusicDto;
import com.bandwith.dto.like.LikeOnRecordDto;
import com.bandwith.dto.member.MemberMonthlyDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository("likeDaoBean")
public class LikeDaoImpl implements LikeDao{

    private SqlSession sqlSession;

    @Autowired
    public LikeDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int countLike(int record_id){
        return sqlSession.selectOne("LikeMapper.countLike", record_id);
    }

    @Override
    public int bandMusicLike(int band_music_id) {
        return sqlSession.selectOne("LikeMapper.bandMusicLike", band_music_id);

    }

    @Override
    public void insertLikeOnRecord(LikeOnRecordDto likeOnRecordDto) {
        sqlSession.insert("LikeMapper.insertLikeOnRecord", likeOnRecordDto);
    }

    @Override
    public void insertLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto) {
        sqlSession.insert("LikeMapper.insertLikeOnBandMusic", likeOnBandMusicDto);
    }

    @Override
    public void deleteLikeOnRecord(LikeOnRecordDto likeOnRecordDto) {
        sqlSession.delete("LikeMapper.deleteLikeOnRecord", likeOnRecordDto);
    }

    @Override
    public void deleteLikeOnBandMusic(LikeOnBandMusicDto likeOnBandMusicDto) {
        sqlSession.delete("LikeMapper.deleteLikeOnBandMusic", likeOnBandMusicDto);
    }


    @Override
    public List<BandMontlyDto> monthlyBand() {
        List<Band> bands= sqlSession.selectList("BandMapper.bandList");
        List<List<BandMusic>> bandMusicsforbandIds = new ArrayList<>();
        List<Integer> likesforBand = new ArrayList<>();
        for(int i=0; i<bands.size(); i++){
            bandMusicsforbandIds.add(sqlSession.selectList("BandMapper.selectBandMusics", Integer.parseInt(String.valueOf(bands.get(i).getBand_id()))));
        }
        for(int i=0; i<bandMusicsforbandIds.size(); i++){
            int sum=0;
            for(int j=0; j<bandMusicsforbandIds.get(i).size(); j++){
                int value=sqlSession.selectOne("LikeMapper.bandMusicLike", bandMusicsforbandIds.get(i).get(j).getBandMusicId());
                sum+=value;
            }
            likesforBand.add(sum);
        }
        List<BandMontlyDto> monthly = new ArrayList<>();
        for(int i=0; i<bands.size(); i++){
            String photo = null;
            if(bands.get(i).getImg() != null) {
                photo = new String(bands.get(i).getImg(), StandardCharsets.UTF_8);
                if( photo.startsWith("\uFEFF") ) {
                    photo = photo.substring(1);
                }
            }
            BandMontlyDto bandMontlyDto = new BandMontlyDto(likesforBand.get(i),bands.get(i).getBand_name(), photo);
            monthly.add(bandMontlyDto);
        }
        return monthly;
    }

    @Override
    public List<MemberMonthlyDto> monthlyMember() {
        List<Member> members= sqlSession.selectList("MemberMapper.memberList");
        List<MemberMonthlyDto> monthly = new ArrayList<>();
        for(int i=0; i<members.size(); i++){
            int like = sqlSession.selectOne("LikeMapper.searchByMemberID", members.get(i).getMember_id());
            MemberMonthlyDto memberMonthlyDto = new MemberMonthlyDto(members.get(i).getUsername(), members.get(i).getProfile_img(), like);
            monthly.add(memberMonthlyDto);
            System.out.println("번호: "+members.get(i).getMember_id()+" 좋아요:"+like);
        }
        return monthly;
    }


}
