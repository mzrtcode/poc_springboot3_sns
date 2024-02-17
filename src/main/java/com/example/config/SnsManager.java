package com.example.config;

import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class SnsManager {
    private SnsClient snsClient;

    public SnsManager() {
        this.snsClient = SnsClient.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(DefaultCredentialsProvider.create()) // Esto es para que tome las credenciales de AWS de tu sistema usuario/.aws/credentials
                .build();
    }

    public void snsRequest(String mensaje, String topicArn){
        PublishRequest publishRequest = PublishRequest.builder()
                .message(mensaje)
                .targetArn(topicArn)
                .build();
        snsClient.publish(publishRequest);
    }

    public void snsRequest(String mensaje, String asunto, String topicArn){
        PublishRequest publishRequest = PublishRequest.builder()
                .message(mensaje)
                .subject(asunto)
                .targetArn(topicArn)
                .build();
        snsClient.publish(publishRequest);
    }


}
