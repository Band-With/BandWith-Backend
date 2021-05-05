package com.bandwith.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface S3Service {
    void uploadFile(String path, MultipartFile file) throws IOException;
    Resource downloadFile(String key) throws IOException;
    void deleteFile(String path);
    String getFileURL(String path);
    void createFolder(String folderName);
}
