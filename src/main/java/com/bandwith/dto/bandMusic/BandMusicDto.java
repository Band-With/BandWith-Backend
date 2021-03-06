package com.bandwith.dto.bandMusic;

import com.bandwith.domain.BandMusic;

import java.sql.Timestamp;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BandMusicDto {
    private int bandMusicId;
    private int bandId;
    private int musicId;
    private Timestamp createdAt;
    private boolean complete;
    private Timestamp completeDate;
    private String uuid;
    private String fileName;
    private String fileUrl;


    public BandMusicDto() {
    }

    public BandMusicDto(int bandMusicId, int bandId, int musicId, Timestamp createdAt, boolean complete, Timestamp completeDate, String uuid, String fileName, String fileUrl) {
        this.bandMusicId = bandMusicId;
        this.bandId = bandId;
        this.musicId = musicId;
        this.createdAt = createdAt;
        this.complete = complete;
        this.completeDate = completeDate;
        this.uuid = uuid;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public static BandMusicDto of(BandMusic bandMusic) {
        return new BandMusicDto(
                bandMusic.getBandMusicId(),
                bandMusic.getBandId(),
                bandMusic.getMusicId(),
                bandMusic.getCreatedAt(),
                bandMusic.isComplete(),
                bandMusic.getCompleteDate(),
                bandMusic.getUuid(),
                bandMusic.getFileName(),
                bandMusic.getFileUrl()
        );
    }

    public int getBandMusicId() {
        return bandMusicId;
    }

    public void setBandMusicId(int bandMusicId) {
        this.bandMusicId = bandMusicId;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Timestamp getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Timestamp completeDate) {
        this.completeDate = completeDate;
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
