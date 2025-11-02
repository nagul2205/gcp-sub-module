package com.gcp.sub.model;

import java.math.BigDecimal;

public class Transaction {
    private String trnxId;
    private char type;
    private BigDecimal amount;

    public String getTrnxId() {
        return trnxId;
    }

    public void setTrnxId(String trnxId) {
        this.trnxId = trnxId;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
