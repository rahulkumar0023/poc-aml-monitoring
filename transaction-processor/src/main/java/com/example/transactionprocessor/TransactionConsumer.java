package com.example.transactionprocessor;

import com.example.transactionprocessor.dto.TransactionRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {

    @KafkaListener(topics = "transaction-events", groupId = "transaction-group")
    public void consume(TransactionRequest tx) {
        System.out.println("Consumed TX: " + tx);
        // TODO: Call Fraud-Check Service next
    }
}
