package com.bandwith.controller;

import com.bandwith.dto.CommentPageDto;
import com.bandwith.dto.SearchRecordDto;
import com.bandwith.dto.like.LikeOnRecordDto;
import com.bandwith.dto.record.RecordInsertDto;
import com.bandwith.dto.record.RecordNameDto;
import com.bandwith.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;


@CrossOrigin
@RestController
public class RecordController {

    private S3Service s3Service;
    private RecordService recordService;
    private CommentService commentService;
    private LikeService likeService;

    @Autowired
    public RecordController(@Qualifier("s3Service") S3Service s3Service,
                            @Qualifier("recordServiceBean") RecordService recordService,
                            @Qualifier("commentServiceBean") CommentService commentService,
                            @Qualifier("likeServiceBean") LikeService likeService) {
        this.s3Service = s3Service;
        this.recordService = recordService;
        this.commentService = commentService;
        this.likeService = likeService;
    }

    // 사용자 녹음 파일 저장
    @RequestMapping(path = "members/{memberId}/records", method = RequestMethod.POST)
    public ResponseEntity recordUpload(@RequestPart("json") String filterJSON,
                                       @RequestPart("file") MultipartFile file,
                                       @PathVariable int memberId) {
        try {
            // S3에 저장
            String uploadPath = "records/";
            String[] fileInfo = s3Service.uploadFile(uploadPath, file); // fileInfo = {uuid, fileName, key}
            String url = s3Service.getFileURL(fileInfo[2]);

            // DB에 저장
            ObjectMapper mapper = new ObjectMapper();
            RecordInsertDto recordInsertDto = mapper.readValue(filterJSON, RecordInsertDto.class);
            recordInsertDto.setUuid(fileInfo[0]);
            recordInsertDto.setFileName(fileInfo[1]);
            recordInsertDto.setFileUrl(fileInfo[2]);
            recordService.insertRecord(recordInsertDto);

            return ResponseEntity.status(HttpStatus.OK).body("insert complete");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 음악에 대한 녹음 파일 가져오기 (필터 적용)
    @GetMapping("/musics/{musicId}/records")
    public ResponseEntity<List<SearchRecordDto>> getRecords(@PathVariable int musicId, String filter) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(recordService.getRecords(musicId, filter));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 녹음 파일 다운로드
    @RequestMapping(path = "/records/{recordId}", method = RequestMethod.GET)
    public ResponseEntity recordDownload(@PathVariable int recordId) {

        try {
            RecordNameDto fileName = recordService.getRecordName(recordId);

            String key = "records/" + fileName.getUuid() + "-" + fileName.getFileName();
            Resource resource = s3Service.downloadFile(key);

            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(resource.contentLength())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName.getFileName())
                    .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 녹음 파일 S3와 데이터베이스에서 삭제
    @RequestMapping(path = "/records/{recordId}", method = RequestMethod.DELETE)
    public ResponseEntity recordDelete(@PathVariable int recordId) {

        try {
            RecordNameDto fileName = recordService.getRecordName(recordId);
            String key = "records/" + fileName.getUuid() + "-" + fileName.getFileName();

            s3Service.deleteFile(key);
            recordService.deleteRecord(recordId);

            return ResponseEntity.status(HttpStatus.OK).body(null);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 녹음 파일의 댓글 가져오기
    @GetMapping("/records/{recordId}/comments")
    public ResponseEntity<List<CommentPageDto>> getRecordComments(@PathVariable int recordId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(commentService.getRecordComments(recordId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 녹음 파일에 좋아요 누르기
    @PostMapping("/records/{recordId}/likes")
    public ResponseEntity insertLike(@PathVariable int recordId,
                                     @RequestBody String filterJSON) {
        try {
//            int memberId = (int)jsonObject.get("memberId");
//            int recordId = (int)jsonObject.get("recordId");

            ObjectMapper mapper = new ObjectMapper();
            LikeOnRecordDto likeOnRecordDto = mapper.readValue(filterJSON, LikeOnRecordDto.class);

            likeService.insertLikeOnRecord(likeOnRecordDto);

            return ResponseEntity.status(HttpStatus.OK).body("insert complete");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 녹음 파일에 좋아요 취소하기
    @DeleteMapping("/records/{recordId}/likes")
    public ResponseEntity deleteLike(@PathVariable int recordId,
                                     @RequestBody String filterJSON) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            LikeOnRecordDto likeOnRecordDto = mapper.readValue(filterJSON, LikeOnRecordDto.class);

            likeService.deleteLikeOnRecord(likeOnRecordDto);

            return ResponseEntity.status(HttpStatus.OK).body("delete complete");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 녹음 잡음 제거
    @PostMapping("/record/denoise")
    public ResponseEntity denoiseFile(@RequestPart("file") MultipartFile file) {

        String path = "c:/band-with/";
        String fileName = file.getOriginalFilename().replace('/', '-');

        // 받은 파일 다운로드
        try {
            AudioService.downloadFile(path, file);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file save error");
        }

        try {
            AudioService.denoiser(path, fileName);  // 잡음 제거

            FileInputStream fis = new FileInputStream(path + "denoise-" + fileName);
            Resource resource = new ByteArrayResource(IOUtils.toByteArray(fis));
            fis.close();

            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(resource.contentLength())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=denoise-" + fileName)
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("denoise file error");
        }
    }
}
