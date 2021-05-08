package com.bandwith.service;

import com.amazonaws.AmazonClientException;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface S3Service {
    String[] uploadFile(String path, MultipartFile file) throws IOException;
    String[] uploadFile(String path, String title, byte[] file) throws AmazonClientException, IOException;
    Resource downloadFile(String key) throws IOException;
    void deleteFile(String path);
    String getFileURL(String path);
    void createFolder(String folderName);
}
