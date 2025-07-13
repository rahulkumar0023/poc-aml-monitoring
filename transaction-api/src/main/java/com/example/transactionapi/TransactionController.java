package com.example.transactionapi;

import com.example.transactionapi.dto.TransactionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @PostMapping("/transactions")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionRequest tx) {
        // TODO: Add Kafka logic later
        System.out.println("Received TX: " + tx);
        return ResponseEntity.ok("Received");
    }
}
