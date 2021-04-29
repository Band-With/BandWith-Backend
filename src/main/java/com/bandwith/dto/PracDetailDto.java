package com.bandwith.dto;

import com.bandwith.dto.music.MusicDto;

import java.util.HashMap;
import java.util.List;

public class PracDetailDto {
    private MusicDto musicDto;
    private List<HashMap<String, Object>> records;

    public PracDetailDto(MusicDto musicDto, List<HashMap<String, Object>> records){
        this.musicDto = musicDto;
        this.records = records;
    }

    public MusicDto getMusicDto() {
        return musicDto;
    }

    public void setMusicDto(MusicDto musicDto) {
        this.musicDto = musicDto;
    }

    public List<HashMap<String, Object>> getRecords() {
        return records;
    }

    public void setRecords(List<HashMap<String, Object>> records) {
        this.records = records;
    }
}
