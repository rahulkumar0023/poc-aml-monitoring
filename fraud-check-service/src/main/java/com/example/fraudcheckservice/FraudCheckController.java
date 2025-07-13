package com.example.fraudcheckservice;

import com.example.fraudcheckservice.dto.TransactionRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fraud-check")
public class FraudCheckController {

    @Value("${fraud.threshold}")
    private double threshold;

    @PostMapping("/validate")
    public ResponseEntity<String> validateTransaction(@RequestBody TransactionRequest tx) {
        if (tx.getAmount() != null && tx.getAmount() > threshold) {
            System.out.println("Flagged: " + tx);
            return ResponseEntity.ok("Suspicious");
        }
        return ResponseEntity.ok("OK");
    }
}
