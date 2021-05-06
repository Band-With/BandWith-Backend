package com.bandwith.controller;

import com.bandwith.dto.CommentPageDto;
import com.bandwith.dto.SearchRecordDto;
import com.bandwith.dto.record.RecordInsertDto;
import com.bandwith.dto.record.RecordNameDto;
import com.bandwith.service.CommentService;
import com.bandwith.service.RecordService;
import com.bandwith.service.S3Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@CrossOrigin
@RestController
public class RecordController {

    private S3Service s3Service;
    private RecordService recordService;
    private CommentService commentService;

    @Autowired
    public RecordController(@Qualifier("s3Service") S3Service s3Service,
                            @Qualifier("recordServiceBean") RecordService recordService,
                            @Qualifier("commentServiceBean") CommentService commentService) {
        this.s3Service = s3Service;
        this.recordService = recordService;
        this.commentService = commentService;
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

    // 녹음 파일 URL로 이동
    @RequestMapping(path = "/records/{recordId}/url", method = RequestMethod.POST)
    public ResponseEntity<String> getFileUrl(@PathVariable int recordId) {

        RecordNameDto fileName = recordService.getRecordName(recordId);
        String key = "records/" + fileName.getUuid() + "-" + fileName.getFileName();
        String url = s3Service.getFileURL(key);

        return ResponseEntity.status(HttpStatus.OK).body(url);
    }

    // 녹음 파일의 댓글 가져오기
    @GetMapping("/records/{recordId}/comments")
    public ResponseEntity<List<CommentPageDto>> getRecordComments(@PathVariable int recordId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getRecordComments(recordId));
    }
}
