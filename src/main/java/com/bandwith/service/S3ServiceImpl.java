package com.bandwith.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.File;
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
    public void fileUpload(String path, MultipartFile file) {

        UUID uid = UUID.randomUUID();
        String key = path + uid + "-" + file.getOriginalFilename().replace('/', '-');

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());

        try {
            // upload the file
            s3Client.putObject(new PutObjectRequest(bucket, key, file.getInputStream(), metadata));
        } catch (AmazonServiceException ase) {
            logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons: ");
            logger.info("Error Message:    " + ase.getMessage());
            logger.info("HTTP Status Code: " + ase.getStatusCode());
            logger.info("AWS Error Code:   " + ase.getErrorCode());
            logger.info("Error Type:       " + ase.getErrorType());
            logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 파일 삭제
    @Override
    public void fileDelete(String path) {

        try {
            // delete the file
            s3Client.deleteObject(bucket, path);
            System.out.println("deletion complete: " + path);
        } catch (AmazonServiceException ase) {
            ase.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 파일 URL
    @Override
    public String getFileURL(String path) {
        return s3Client.generatePresignedUrl(new GeneratePresignedUrlRequest(bucket, path)).toString();
    }

    // 폴더 생성
    @Override
    public void createFolder(String folderName) {
        s3Client.putObject(bucket, folderName + "/", new ByteArrayInputStream(new byte[0]), new ObjectMetadata());
    }
}
