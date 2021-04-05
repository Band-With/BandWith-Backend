package com.bandwith.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    String[] fileUpload(String path, MultipartFile file);
    void fileDelete(String path);
    String getFileURL(String path);
    void createFolder(String folderName);
}
