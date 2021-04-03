package com.bandwith.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    void fileUpload(String uploadPath, MultipartFile file);
}
