package com.bandwith.dto.band;

import com.bandwith.domain.BandMusic;
import com.bandwith.domain.Music;
import com.bandwith.dto.music.MusicDto;

import java.sql.Timestamp;

public class BandMusicDetailDto {
    private int bandMusicId;
    private Timestamp createdAt;
    private Timestamp completeDate;

    private MusicDto music;

    private String uuid;
    private String fileName;
    private String fileUrl;


    public BandMusicDetailDto() {

    }

    public BandMusicDetailDto(int bandMusicId, Timestamp createdAt, Timestamp completeDate, MusicDto music, String uuid, String fileName, String fileUrl) {
        this.bandMusicId = bandMusicId;
        this.createdAt = createdAt;
        this.completeDate = completeDate;
        this.music = music;
        this.uuid = uuid;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public static BandMusicDetailDto of(BandMusic bandMusic, Music musicEntity){
        MusicDto music = MusicDto.of(musicEntity);
        return new BandMusicDetailDto(bandMusic.getBandMusicId(), bandMusic.getCreatedAt(), bandMusic.getCompleteDate(), music, bandMusic.getUuid(), bandMusic.getFileName(), bandMusic.getFileUrl());
    }

    public int getBandMusicId() {
        return bandMusicId;
    }

    public void setBandMusicId(int bandMusicId) {
        this.bandMusicId = bandMusicId;
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
