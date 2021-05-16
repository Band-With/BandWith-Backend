package com.bandwith.service;

import com.bandwith.dto.CommentPageDto;
import com.bandwith.dto.comment.CommentCreateDto;

import java.util.List;

public interface CommentService {
    List<CommentPageDto> getRecordComments(int recordId);
    List<CommentPageDto> getBandMusicComments(int bandMusicId);
    void createComment(CommentCreateDto comment);
    void updateComment(int commentId, String content);
    void deleteComment(int commentId);
}
