package com.bandwith.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.UUID;


@Service("s3Service")
public class S3ServiceImpl implements S3Service {

    private final Logger logger = LoggerFactory.getLogger(S3ServiceImpl.class);
    private AmazonS3 s3Client;

    @Value("#{s3Properties['aws.access_key_id']}")
    private String accessKey;

    @Value("#{s3Properties['aws.secret_access_key']}")
    private String secretKey;

    @Value("#{s3Properties['aws.s3.bucket']}")
    private String bucket;

    @Value("#{s3Properties['aws.s3.region']}")
    private String region;

    @PostConstruct
    public void setS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(this.region)
                .build();
    }

    // 파일 업로드
    @Override
    public String[] uploadFile(String path, MultipartFile file) throws AmazonClientException, IOException {
        String[] fileInfo = getFileInfo(path, file.getOriginalFilename());   // fileInfo = {uid, fileName, key}

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());

        s3Client.putObject(new PutObjectRequest(bucket, fileInfo[2], file.getInputStream(), metadata));
        return fileInfo;
    }

    @Override
    public String[] uploadFile(String path, String title, byte[] bfile) throws AmazonClientException, IOException {
        String[] fileInfo = getFileInfo(path, title);   // fileInfo = {uid, fileName, key}

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("audio/wav");
        metadata.setContentLength(bfile.length);

        s3Client.putObject(new PutObjectRequest(bucket, fileInfo[2], new ByteArrayInputStream(bfile), metadata));

        return fileInfo;
    }

    private String[] getFileInfo(String path, String fileName) {
        String uid = UUID.randomUUID().toString();
        fileName = fileName.replace('/', '-');
        String key = path + uid + "-" + fileName;

        return new String[]{uid, fileName, key};
    }

    // 파일 다운로드
    @Override
    public Resource downloadFile(String key) throws AmazonServiceException, IOException {
        S3Object o = s3Client.getObject(bucket, key);
        S3ObjectInputStream s3is = o.getObjectContent();
        byte[] bytes = IOUtils.toByteArray(s3is);

        Resource resource = new ByteArrayResource(bytes);
        return resource;
    }


    // 파일 삭제
    @Override
    public void deleteFile(String path) throws AmazonServiceException {
        s3Client.deleteObject(bucket, path);
        System.out.println("delete s3 service: " + path);
    }

    // 파일 URL
    @Override
    public String getFileURL(String path) throws AmazonServiceException {
        return s3Client.generatePresignedUrl(new GeneratePresignedUrlRequest(bucket, path)).toString();
    }

    // 폴더 생성
    @Override
    public void createFolder(String folderName) throws AmazonServiceException {
        s3Client.putObject(bucket, folderName + "/", new ByteArrayInputStream(new byte[0]), new ObjectMetadata());
    }
}
