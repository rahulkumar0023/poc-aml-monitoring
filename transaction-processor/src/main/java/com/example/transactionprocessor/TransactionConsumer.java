package com.example.transactionprocessor;

import com.example.transactionprocessor.dto.TransactionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionConsumer {

    @KafkaListener(topics = "transaction-events", groupId = "transaction-group")
    public void consume(TransactionRequest tx) {
        System.out.println("Consumed TX: " + tx);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://fraud-check-service:8080/fraud-check/validate",
            tx,
            String.class
        );
        System.out.println("Fraud check response: " + response.getBody());
    }
}
