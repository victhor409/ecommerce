package com.ecommerce.aws.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;

import java.net.URI;

@Service
public class AWSConfig {

    @Value("${aws.endpoint}")
    private String awsEndpoint;

    @Bean
    public S3Client s3Client(){
        return S3Client.builder()
                .endpointOverride(URI.create(awsEndpoint))
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create("teste","teste")
                        )
                ).region(Region.of("us-east-1"))
                .serviceConfiguration(S3Configuration.builder()
                        .pathStyleAccessEnabled(true)//necessario para o localstack
                        .build())
                .build();
    }
}
