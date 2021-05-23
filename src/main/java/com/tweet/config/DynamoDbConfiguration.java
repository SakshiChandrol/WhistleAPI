package com.tweet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDbConfiguration {

	@Bean
	public DynamoDBMapper dynamoDBMapper() {
	return new DynamoDBMapper(buildAmazonDynamoDB());
}

	private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("dynamodb.ap-south-1.amazonaws.com", "ap-south-1"))
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials("AKIA27JBG4O5CNJYTTU3", "1bGPZZesKy0f3eM0+h63tgxfVT7mpWEg1tlwsI62")))
                .build();
    }
}
