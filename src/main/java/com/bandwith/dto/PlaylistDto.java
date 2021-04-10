package com.bandwith.dto;

import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordDto;

public class PlaylistDto {
    RecordDto record;
    MusicDto music;

    public PlaylistDto(RecordDto record,MusicDto music) {
        this.record = record;
        this.music = music;
    }

    public RecordDto getRecord() {
        return record;
    }

    public void setRecord(RecordDto record) {
        this.record = record;
    }

    public MusicDto getMusic() {
        return music;
    }

    public void setMusic(MusicDto music) {
        this.music = music;
    }
}
