package com.bandwith.dto;

import com.bandwith.dto.comment.CommentDto;
import com.bandwith.dto.member.MemberBasicDto;

public class CommentPageDto {
    private MemberBasicDto member;
    private CommentDto comment;

    public CommentPageDto(MemberBasicDto member, CommentDto comment) {
        this.member = member;
        this.comment = comment;
    }

    public MemberBasicDto getMember() {
        return member;
    }

    public void setMember(MemberBasicDto member) {
        this.member = member;
    }

    public CommentDto getComment() {
        return comment;
    }

    public void setComment(CommentDto comment) {
        this.comment = comment;
    }
}
