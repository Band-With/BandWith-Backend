package com.bandwith.dto;

import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordDto;

import java.util.HashMap;
import java.util.List;

public class RecordDetailDto {

    private RecordDto music;\
    private List<HashMap<String, Object>> records;

    public RecordDetailDto(MusicDto music, List<HashMap<String, Object>> records){
        this.music = music;
        this.records = records;
    }

    public MusicDto getMusic() {
        return music;
    }

    public void setMusic(MusicDto music) {
        this.music = music;
    }

    public List<HashMap<String, Object>> getRecords() {
        return records;
    }

    public void setRecords(List<HashMap<String, Object>> records) {
        this.records = records;
    }


}
