package com.bandwith.controller;

import com.bandwith.dto.record.RecordInsertDto;
import com.bandwith.dto.record.RecordNameDto;
import com.bandwith.service.RecordService;
import com.bandwith.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin
@RestController
@RequestMapping("/members/{memberId}")
//@Controller
public class S3Controller {

    private S3Service s3Service;
    private RecordService recordService;

    @Autowired
    public S3Controller(@Qualifier("s3Service") S3Service s3Service,
                        @Qualifier("recordServiceBean") RecordService recordService) {
        this.s3Service = s3Service;
        this.recordService = recordService;
    }

    @RequestMapping(path = "/records", method = RequestMethod.POST)
    public ResponseEntity recordUpload(@RequestBody String filterJSON, @RequestParam("file") MultipartFile file,
                               @PathVariable int memberId) {

        try {
            String uploadPath = "records/";
            String[] fileInfo = s3Service.fileUpload(uploadPath, file); // fileInfo = {uuid, fileName}

            // TODO : @RequestBody String filterJSON
            RecordInsertDto record = new RecordInsertDto(1, memberId, null, false, false, fileInfo[0], fileInfo[1]);
            recordService.uploadRecord(record);

            return ResponseEntity.status(HttpStatus.OK).body(null);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(path = "/records/recordId", method = RequestMethod.GET)
    public ResponseEntity recordDownload(@PathVariable int recordId) {

        try {
            System.out.println(recordId);
            RecordNameDto fileName = recordService.getRecordName(recordId);

            String key = "records/" + fileName.getUuid() + "-" + fileName.getFileName();
            Resource resource = s3Service.fileDownload(key);

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

    @RequestMapping(path = "/records/{recordId}", method = RequestMethod.DELETE)
    public ResponseEntity recordDelete(@PathVariable int memberId, @PathVariable int recordId) {

        try {
            RecordNameDto fileName = recordService.getRecordName(recordId);
            String key = "records/" + fileName.getUuid() + "-" + fileName.getFileName();

            s3Service.fileDelete(key);
            recordService.deleteRecord(recordId);

            return ResponseEntity.status(HttpStatus.OK).body(null);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(path = "/records/{recordId}/url", method = RequestMethod.POST)
    public ResponseEntity<String> moveFileUrl(@PathVariable int recordId) {

        RecordNameDto fileName = recordService.getRecordName(recordId);
        String key = "records/" + fileName.getUuid() + "-" + fileName.getFileName();
        String url = s3Service.getFileURL(key);

        return ResponseEntity.status(HttpStatus.OK).body(url);
    }

    @RequestMapping("/test")
    public String uploadFile() {
        return "recordTest";
    }
}
