package com.bandwith.service;

import com.bandwith.dto.PracDetailDto;
import com.bandwith.dto.RecordDetailDto;

import java.util.List;

public interface RecordDetailService {
    RecordDetailDto getRecordDetail(int member_id, int music_id,, String title, List<Integer> members);

}
