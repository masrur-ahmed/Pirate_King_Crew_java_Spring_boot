package com.example.zorodemo.zorodemo.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class DynamoDbConf {
    @Configuration
    public class DynamoDbConfiguration {
        private static final String DYNAMODB_URL = "http://localhost:8566";
        private static final String SIGNINGREGION = "ap-southeast-1";
        private static final String ACCESSKEY ="Key";
        private static final String SECRETKEY = "Key";
        @Bean(name= "dynamoDB")
        public DynamoDBMapper dynamoDBMapper() {
            return new DynamoDBMapper(buildAmazonDynamoDB());
        }

        private AmazonDynamoDB buildAmazonDynamoDB() {
            return AmazonDynamoDBClientBuilder
                    .standard()
                    .withEndpointConfiguration(
                            new AwsClientBuilder.EndpointConfiguration(
                                    DYNAMODB_URL,
                                    SIGNINGREGION
                            )
                    )
                    .withCredentials(
                            new AWSStaticCredentialsProvider(
                                    new BasicAWSCredentials(
                                            ACCESSKEY,
                                            SECRETKEY
                                    )
                            )
                    )
                    .build();
        }

    }

}
