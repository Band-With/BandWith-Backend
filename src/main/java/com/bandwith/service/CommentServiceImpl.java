package com.bandwith.service;

import com.bandwith.dao.CommentDao;
import com.bandwith.dao.MemberDao;
import com.bandwith.domain.Comment;
import com.bandwith.dto.CommentPageDto;
import com.bandwith.dto.comment.CommentCreateDto;
import com.bandwith.dto.comment.CommentDto;
import com.bandwith.dto.member.MemberBasicDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("commentServiceBean")
public class CommentServiceImpl implements CommentService{
    private CommentDao commentDao;
    private MemberDao memberDao;

    @Autowired
    public CommentServiceImpl(@Qualifier("commentDaoBean") CommentDao commentDao,
                              @Qualifier("memberDaoBean") MemberDao memberDao){
        this.commentDao = commentDao;
        this.memberDao = memberDao;
    }

    public List<CommentPageDto> getRecordComments(int recordId){
        List<Comment> comments = commentDao.getRecordComments(recordId);
        List<CommentPageDto> commentPageDtoList = new ArrayList<>();

        for(Comment comment: comments)
            commentPageDtoList.add(new CommentPageDto(MemberBasicDto.of(memberDao.selectMember(comment.getMember_id())), CommentDto.of(comment)));
        return commentPageDtoList;
    }

    public void createComment(CommentCreateDto comment) {
        commentDao.createComment(comment);
    }

    public void updateComment(int commentId, String content) {
        HashMap<String, Object> comment = new HashMap<String, Object>();
        comment.put("commentId", commentId);
        comment.put("content", content);
        commentDao.updateComment(comment);
    }

    public void deleteComment(int commentId) {
        commentDao.deleteComment(commentId);
    }
}
