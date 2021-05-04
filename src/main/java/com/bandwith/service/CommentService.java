package com.bandwith.service;

import com.bandwith.dto.CommentPageDto;

import java.util.List;

public interface CommentService {
    List<CommentPageDto> getRecordComments(int recordId);
}
