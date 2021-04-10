package com.bandwith.dao;

import com.bandwith.domain.Music;

public interface MusicDao {
    Music selectMusic(int record_id);
}
