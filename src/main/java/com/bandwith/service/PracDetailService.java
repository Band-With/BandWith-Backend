package com.bandwith.service;

import com.bandwith.dto.PracDetailDto;

public interface PracDetailService {
    PracDetailDto getPracDetail(String username, int musicId, Boolean condition);
    void patchRecordAttributes(int recordId, Boolean access, Boolean searchable);
}
