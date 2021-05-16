package com.bandwith.dto.record;


import com.bandwith.domain.Music;
import com.bandwith.domain.Record;
import com.bandwith.dto.music.MusicDto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class RecordForBandDto {
    private int band_music_id;
    private int music_id;
    private int band_id;
    private Timestamp created_at;
    private Timestamp complete_date;
    private boolean complete;
    private String file_name; //modify to real file
    private String file_url; //modify to real file
    private String uuid;

    public int getBand_music_id() {
        return band_music_id;
    }

    public void setBand_music_id(int band_music_id) {
        this.band_music_id = band_music_id;
    }

    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public int getBand_id() {
        return band_id;
    }

    public void setBand_id(int band_id) {
        this.band_id = band_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getComplete_date() {
        return complete_date;
    }

    public void setComplete_date(Timestamp complete_date) {
        this.complete_date = complete_date;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public RecordForBandDto(int band_music_id, int band_id, int music_id , Timestamp created_at,  boolean complete, Timestamp complete_date, String uuid, String file_name, String file_url) {
        this.band_music_id = band_music_id;
        this.music_id = music_id;
        this.band_id = band_id;
        this.created_at = created_at;
        this.complete_date = complete_date;
        this.complete = complete;
        this.file_name = file_name;
        this.file_url = file_url;
        this.uuid = uuid;
    }
}