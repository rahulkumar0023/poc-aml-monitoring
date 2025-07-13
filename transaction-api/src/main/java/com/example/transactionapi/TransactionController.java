package com.example.transactionapi;

import com.example.transactionapi.dto.TransactionRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private final KafkaTemplate<String, TransactionRequest> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    public TransactionController(KafkaTemplate<String, TransactionRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/transactions")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionRequest tx) {
        System.out.println("Received TX: " + tx);
        kafkaTemplate.send(topicName, tx);
        return ResponseEntity.ok("Transaction published to Kafka");
    }
}
