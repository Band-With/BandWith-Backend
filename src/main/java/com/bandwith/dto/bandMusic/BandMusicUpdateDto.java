package com.bandwith.dto.bandMusic;

public class BandMusicUpdateDto {
    private int bandMusicId;
    private boolean complete;
    private String uuid;
    private String fileName;
    private String fileUrl;

    public BandMusicUpdateDto(int bandMusicId, boolean complete, String uuid, String fileName, String fileUrl) {
        this.bandMusicId = bandMusicId;
        this.complete = complete;
        this.uuid = uuid;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public int getBandMusicId() {
        return bandMusicId;
    }

    public void setBandMusicId(int bandMusicId) {
        this.bandMusicId = bandMusicId;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
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
