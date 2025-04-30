package com.ecommerce.aws.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;

@Service
public class S3BucketInit {

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Autowired
    private S3Client s3Client;

    @PostConstruct
    public void init(){
        try{
            s3Client.createBucket(b -> b.bucket(bucketName));
            System.out.println("Bucket criado: "+ bucketName);
        }catch (Exception e){
            System.err.println("Bucket já existe ou erro ao criar: " + e.getMessage());
        }
    }
}
