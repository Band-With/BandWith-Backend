package com.bandwith.dto.comment;

import com.bandwith.domain.Comment;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CommentDto {
    private int comment_id;
    private String content;
    private Timestamp created_at;

    public CommentDto(int comment_id, String content, Timestamp created_at) {
        this.comment_id = comment_id;
        this.content = content;
        this.created_at = created_at;
    }

    public static CommentDto of(Comment comment){
        return new CommentDto(comment.getComment_id(), comment.getContent(), comment.getCreated_at());
    }

    public static List<CommentDto> of(List<Comment> comments){
        List<CommentDto> commentDtoList = new ArrayList<>();
        for(Comment comment: comments)
            commentDtoList.add(CommentDto.of(comment));
        return commentDtoList;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
