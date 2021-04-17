package com.bandwith.dto.record;

public class RecordNameDto {
    private String uuid;
    private String fileName;

    public RecordNameDto(String uuid, String fileName) {
        this.uuid = uuid;
        this.fileName = fileName;
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
}
