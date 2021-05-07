package com.bandwith.controller;

import com.bandwith.dto.bookmark.BookmarkInsertDto;
import com.bandwith.service.BookmarkService;
import com.bandwith.service.S3Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin
@RestController
public class BookmarkController {

    private S3Service s3Service;
    private BookmarkService bookmarkService;

    @Autowired
    public BookmarkController(@Qualifier("s3Service") S3Service s3Service,
                              @Qualifier("bookmarkServiceBean") BookmarkService bookmarkService) {
        this.s3Service = s3Service;
        this.bookmarkService = bookmarkService;
    }

    @PostMapping("/members/{memberId}/bookmarks")
    public ResponseEntity uploadBookmark(@RequestPart("json") String filterJSON,
                                         @RequestPart("file") MultipartFile file,
                                         @PathVariable int memberId) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            BookmarkInsertDto bookmarkInsertDto = mapper.readValue(filterJSON, BookmarkInsertDto.class);

            String uploadPath = "bookmarks/";
            String key = s3Service.uploadFile(uploadPath, file)[2];
            String url = s3Service.getFileURL(key);

//            bookmarkInsertDto.setMemberId(memberId);
            bookmarkInsertDto.setFileUrl(url);
            bookmarkService.insertBookmark(bookmarkInsertDto);

            return ResponseEntity.ok("insert complete");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/bookmarks/{bookmarkId}")
    public ResponseEntity deleteBookmark(@PathVariable int bookmarkId) {
        try {
            bookmarkService.deleteBookmark(bookmarkId);

            return ResponseEntity.ok("delete complete");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
