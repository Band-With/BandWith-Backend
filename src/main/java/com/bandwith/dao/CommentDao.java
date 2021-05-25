package com.bandwith.dao;

import com.bandwith.domain.Comment;
import com.bandwith.dto.comment.CommentCreateDto;

import java.util.HashMap;
import java.util.List;

public interface CommentDao {
    int countComment(int record_id);
    List<Comment> getRecordComments(int recordId);
    List<Comment> getBandMusicComments(int bandMusicId);
    void createComment(CommentCreateDto comment);
    void updateComment(HashMap<String, Object> params);
    void deleteComment(int commentId);


    int bandMusicComments(int band_music_id);
}
