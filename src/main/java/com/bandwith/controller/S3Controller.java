package com.bandwith.controller;

import com.bandwith.dto.record.RecordNameDto;
import com.bandwith.service.RecordService;
import com.bandwith.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class S3Controller {

    private S3Service s3Service;
    private RecordService recordService;

    @Autowired
    public S3Controller(@Qualifier("s3Service") S3Service s3Service,
                        @Qualifier("recordServiceBean") RecordService recordService) {
        this.s3Service = s3Service;
        this.recordService = recordService;
    }

    @RequestMapping(path = "/members/{memberId}/records", method = RequestMethod.POST)
    public String recordUpload(@RequestParam("file") MultipartFile file,
                               @PathVariable int memberId) {

        try {
            String uploadPath = "records/";
            String[] fileInfo = s3Service.fileUpload(uploadPath, file); // {uuid, fileName}

            // TODO : make dto
            recordService.uploadRecord(1, memberId, null, false, false, fileInfo[0], fileInfo[1]);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

//    @ResponseBody
//    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//    public String uploadAjaxCertificate(MultipartFile file) throws Exception {
//
//        String uploadPath = "records/";
//
//        ResponseEntity<String> img_path = new ResponseEntity<>(uploadPath + fileName, HttpStatus.CREATED);
//        String certificatePath = img_path.getBody();
//
//        return certificatePath;
//    }

    @RequestMapping(path = "/members/{memberId}/records/{recordId}", method = RequestMethod.DELETE)
    public String recordDelete(@PathVariable int memberId, @PathVariable int recordId) {

        try {
            RecordNameDto fileName = recordService.getRecordName(recordId);
            String key = "records/" + fileName.getUuid() + "-" + fileName.getFileName();
            s3Service.fileDelete(key);
            recordService.deleteRecord(recordId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping(path = "/records/{recordId}/url", method = RequestMethod.POST)
    public String moveFileUrl(@PathVariable int recordId) throws Exception {

        RecordNameDto fileName = recordService.getRecordName(recordId);
        String key = "records/" + fileName.getUuid() + "-" + fileName.getFileName();
        return "redirect:" + s3Service.getFileURL(key);
    }

    @RequestMapping("/records/test")
    public String uploadFile() throws Exception {
        return "recordTest";
    }
}
