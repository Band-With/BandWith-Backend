package com.bandwith.controller;


import com.bandwith.dto.comment.CommentCreateDto;
import com.bandwith.service.CommentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(@Qualifier("commentServiceBean") CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/members/{username}/comments")
    public ResponseEntity createComment(@RequestBody String filterJSON) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CommentCreateDto commentDto = mapper.readValue(filterJSON, CommentCreateDto.class);
        commentService.createComment(commentDto);

        return ResponseEntity.ok("insert complete");
    }

    @DeleteMapping("/members/{username}/comments")
    public ResponseEntity deleteComment(int commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("deleted");
    }

    @PatchMapping("/members/{username}/comments")
    public ResponseEntity updateComment(int commentId, String comment){
        commentService.updateComment(commentId, comment);
        return ResponseEntity.ok("updated");
    }
}
