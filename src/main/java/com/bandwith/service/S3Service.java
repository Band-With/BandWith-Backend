package com.bandwith.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface S3Service {
    String[] fileUpload(String path, MultipartFile file) throws IOException;
    Resource fileDownload(String key) throws IOException;
    void fileDelete(String path);
    String getFileURL(String path);
    void createFolder(String folderName);
}
