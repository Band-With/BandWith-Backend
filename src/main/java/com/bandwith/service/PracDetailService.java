package com.bandwith.service;

import com.bandwith.dto.PracDetailDto;

public interface PracDetailService {
    PracDetailDto getPracDetail(String username, String title, Boolean condition);
}
