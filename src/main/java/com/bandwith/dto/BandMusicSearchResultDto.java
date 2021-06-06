package com.bandwith.dto;

import com.bandwith.domain.Band;
import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Member;
import com.bandwith.domain.Music;
import com.bandwith.dto.band.BandDto;
import com.bandwith.dto.bandMusic.BandMusicDetailDto;
import com.bandwith.dto.member.MemberBasicDto;
import com.bandwith.dto.music.MusicDto;

import java.sql.Timestamp;
import java.util.List;

public class BandMusicSearchResultDto {
    private int bandMusicId;
    private int likes;
    private int comments;

    private Timestamp createdAt;
    private Timestamp completeDate;

    private MusicDto music;
    private List<MemberBasicDto> members;

    private String uuid;
    private String fileName;
    private String fileUrl;

    private BandDto band;


    public BandMusicSearchResultDto() {

    }

    public BandMusicSearchResultDto(int bandMusicId, int likes, int comments,
                                    Timestamp createdAt, Timestamp completeDate,
                                    MusicDto music, List<MemberBasicDto> members,
                                    String uuid, String fileName, String fileUrl, BandDto band) {
        this.bandMusicId = bandMusicId;
        this.likes = likes;
        this.comments = comments;

        this.createdAt = createdAt;
        this.completeDate = completeDate;

        this.music = music;
        this.members = members;

        this.uuid = uuid;
        this.fileName = fileName;
        this.fileUrl = fileUrl;

        this.band = band;
    }

    public static BandMusicSearchResultDto of(BandMusic bandMusic, int likes, int comments, Music musicEntity, List<Member> membersEntity, Band bandEntity){
        BandDto band = BandDto.of(bandEntity);
        MusicDto music = MusicDto.of(musicEntity);
        List<MemberBasicDto> members = MemberBasicDto.of(membersEntity);
        return new BandMusicSearchResultDto(
                bandMusic.getBandMusicId(), likes, comments,
                bandMusic.getCreatedAt(), bandMusic.getCompleteDate(),
                music, members,
                bandMusic.getUuid(), bandMusic.getFileName(), bandMusic.getFileUrl(), band
        );
    }

    public BandDto getBand() {
        return band;
    }

    public void setBand(BandDto band) {
        this.band = band;
    }

    public int getBandMusicId() {
        return bandMusicId;
    }

    public void setBandMusicId(int bandMusicId) {
        this.bandMusicId = bandMusicId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Timestamp completeDate) {
        this.completeDate = completeDate;
    }

    public MusicDto getMusic() {
        return music;
    }

    public void setMusic(MusicDto music) {
        this.music = music;
    }

    public List<MemberBasicDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberBasicDto> members) {
        this.members = members;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
