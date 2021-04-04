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

    @RequestMapping(path = "/members/{memberId}/records", method = RequestMethod.POST)
    public String recordUpload(@RequestParam("file") MultipartFile file,
                               @PathVariable int memberId) {

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

    @RequestMapping(path = "/member/{memberId}/records", method = RequestMethod.DELETE)
    public String recordDelete(@RequestParam("fileName") String fileName,
                               @PathVariable int memberId) {

        try {
            String filePath = "records/" + fileName;
            s3Service.fileDelete(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/";
    }

    @RequestMapping(path = "/records/{recordId}", method = RequestMethod.POST)
    public String moveFileUrl(@RequestParam("fileName") String fileName,
                              @PathVariable int recordId) throws Exception {

        String filePath = "records/" + fileName;
        System.out.println(s3Service.getFileURL(filePath));
        return "redirect:" + s3Service.getFileURL(filePath);
    }

    @RequestMapping("/record/test")
    public String uploadFile() throws Exception {
        return "recordTest";
    }
}
