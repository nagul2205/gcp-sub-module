package com.gcp.sub.model;

import java.math.BigDecimal;

public class Notification {
    private String trnxId;
    private char transactionType;
    private BigDecimal amount;
    private String status;

    public String getTrnxId() {
        return trnxId;
    }

    public void setTrnxId(String trnxId) {
        this.trnxId = trnxId;
    }

    public char getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(char transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "trnxId='" + trnxId + '\'' +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
