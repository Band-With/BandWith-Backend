package com.bandwith.service;

import com.bandwith.dao.MusicDao;
import com.bandwith.dao.RecordDao;
import com.bandwith.domain.Music;
import com.bandwith.domain.Record;
import com.bandwith.dto.PlaylistDto;
import com.bandwith.dto.music.MusicDto;
import com.bandwith.dto.record.RecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("recordServiceBean")
public class RecordServiceImpl implements RecordService{
    private RecordDao recordDao;
    private MusicDao musicDao;

    @Autowired
    public RecordServiceImpl(@Qualifier("recordDaoBean") RecordDao recordDao,
                             @Qualifier("musicDaoBean") MusicDao musicDao){
        this.recordDao = recordDao;
        this.musicDao = musicDao;
    }

    public List<PlaylistDto> getMyRecord(String username) {
        List<Record> records = recordDao.selectRecords(username);
        List<RecordDto> recordsDto = RecordDto.of(records);

        List<PlaylistDto> playlistsDto = new ArrayList<PlaylistDto>();
        for (int i=0; i < records.size(); i++){
            int music_id = recordsDto.get(i).getMusic_id();
            Music music = musicDao.selectMusic(music_id);
            MusicDto musicDto = MusicDto.of(music);
            playlistsDto.add(new PlaylistDto(recordsDto.get(i), musicDto));
        }

        return playlistsDto;
    }
}
