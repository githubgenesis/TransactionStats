package com.n26.transaction.domain;

import javax.validation.constraints.NotNull;

/**
 * This is transaction class for getting a data from request
 * @author dhiren
 * @since 19-05-2018
 */
public class Transaction {

    @NotNull
    private Double amount;

    @NotNull
    private Long timestamp;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
