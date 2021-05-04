package com.bandwith.dao;

import com.bandwith.domain.Comment;

import java.util.List;

public interface CommentDao {
    int countComment(int record_id);
    List<Comment> getRecordComments(int recordId);
}
