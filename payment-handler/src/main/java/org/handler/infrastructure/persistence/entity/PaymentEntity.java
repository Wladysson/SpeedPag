package org.handler.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    private String id;

    @Column(
            name = "payer_account_id",
            nullable = false
    )
    private String payerAccountId;

    @Column(
            name = "receiver_account_id",
            nullable = false
    )
    private String receiverAccountId;

    @Column(
            nullable = false,
            precision = 19,
            scale = 2
    )
    private BigDecimal amount;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private String status;

    public PaymentEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayerAccountId() {
        return payerAccountId;
    }

    public void setPayerAccountId(
            String payerAccountId
    ) {
        this.payerAccountId = payerAccountId;
    }

    public String getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(
            String receiverAccountId
    ) {
        this.receiverAccountId = receiverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(
            BigDecimal amount
    ) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(
            String description
    ) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {
        this.status = status;
    }
}