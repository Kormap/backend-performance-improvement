package com.performance.improvement.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    CloudFlare R2 스토리지는 S3 SDK 사용하여 동일한 방식으로 동작
 */
@Configuration
public class CloudFlareR2Config {
    @Value("${cloud.flare.endpoint}")
    private String cloudFlareEndPointUrl;

    @Value("${cloud.flare.region}")
    private String cloudFlareRegion;

    @Value("${cloud.flare.accessKey}")
    private String accessKey;

    @Value("${cloud.flare.secretKey}")
    private String secretKey;

    @Bean
    public AmazonS3 client() {

        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);

        return AmazonS3ClientBuilder
                .standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(cloudFlareEndPointUrl, cloudFlareRegion))
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}
