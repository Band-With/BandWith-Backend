package com.bandwith.controller;


import com.bandwith.dto.CommentPageDto;
import com.bandwith.dto.comment.CommentCreateDto;
import com.bandwith.service.CommentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(@Qualifier("commentServiceBean") CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/bands/{band_id}/band_musics/{band_music_id}/comments")
    public ResponseEntity<List<CommentPageDto>> getBandMusicRecord (@PathVariable("band_music_id") int bandMusicId){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getBandMusicComments(bandMusicId));
    }

    @GetMapping("/records/{recordId}/comments")
    public ResponseEntity<List<CommentPageDto>> getRecordComments(@PathVariable int recordId){
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getRecordComments(recordId));
    }

    @PostMapping("/members/{username}/comments")
    public ResponseEntity createComment(@RequestBody String filterJSON) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CommentCreateDto commentDto = mapper.readValue(filterJSON, CommentCreateDto.class);
        commentService.createComment(commentDto);

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @DeleteMapping("/members/{username}/comments/{comment_id}")
    public ResponseEntity deleteComment(@PathVariable("comment_id") int commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("deleted");
    }

    @PatchMapping("/members/{username}/comments/{comment_id}")
    public ResponseEntity updateComment(@PathVariable("comment_id") int commentId,  @RequestBody JSONObject jsonObject){
        String comment = (String)jsonObject.get("content");
        commentService.updateComment(commentId, comment);
        return ResponseEntity.ok("updated");
    }
}
