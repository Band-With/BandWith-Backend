package com.bandwith.dto;

import com.bandwith.dto.band.BandMusicRecordDto;
import com.bandwith.dto.music.MusicDto;

import java.util.List;

public class MixDetailDto {
    MusicDto music;
    List<BandMusicRecordDto> records;

    public MixDetailDto(MusicDto music, List<BandMusicRecordDto> records) {
        this.music = music;
        this.records = records;
    }

    public MusicDto getMusic() {
        return music;
    }

    public void setMusic(MusicDto music) {
        this.music = music;
    }

    public List<BandMusicRecordDto> getRecords() {
        return records;
    }

    public void setRecords(List<BandMusicRecordDto> records) {
        this.records = records;
    }
}
