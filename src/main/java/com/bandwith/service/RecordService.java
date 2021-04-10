package com.bandwith.service;

import com.bandwith.dto.PlaylistDto;

import java.util.List;

public interface RecordService {
    List<PlaylistDto> getMyRecord(String username);
}
