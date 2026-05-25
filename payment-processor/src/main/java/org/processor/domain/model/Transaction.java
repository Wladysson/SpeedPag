package org.processor.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Transaction {

    private String id;

    private String paymentId;

    private BigDecimal amount;

    private SagaStepStatus status;

    public Transaction() {
        this.id = UUID.randomUUID()
                .toString();
    }

    public String getId() {
        return id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(
            String paymentId
    ) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(
            BigDecimal amount
    ) {
        this.amount = amount;
    }

    public SagaStepStatus getStatus() {
        return status;
    }

    public void setStatus(
            SagaStepStatus status
    ) {
        this.status = status;
    }
}