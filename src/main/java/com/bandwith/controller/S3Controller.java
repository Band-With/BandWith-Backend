package com.bandwith.controller;

import com.bandwith.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class S3Controller {

    @Autowired
    private S3Service s3Service;

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String recordUpload(@RequestParam("file") MultipartFile file) {

        try {
            // TODO change upload path
            String uploadPath = "records/";
            s3Service.fileUpload(uploadPath, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/";
    }

//    @ResponseBody
//    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
//    public String uploadAjaxCertificate(MultipartFile file) throws Exception {
//
//        String uploadPath = "bucket-band-with/record/";
//
//        ResponseEntity<String> img_path = new ResponseEntity<>(
//                UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
//                HttpStatus.CREATED);
//        String certificatePath = img_path.getBody();
//
//        return certificatePath;
//    }

    @RequestMapping("/upload")
    public String uploadFile() throws Exception {
        return "upload";
    }
}
