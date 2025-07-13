package com.example.transactionprocessor.dto;

public class TransactionRequest {
    private String accountId;
    private Double amount;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
            "accountId='" + accountId + '\'' +
            ", amount=" + amount +
            '}';
    }
}
