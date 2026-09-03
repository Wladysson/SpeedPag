package org.handler.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Payment {

    private String id;

    private String payerAccountId;

    private String receiverAccountId;

    private BigDecimal amount;

    private String description;

    private PaymentStatus status;

    public Payment() {
        this.id = UUID.randomUUID().toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getPayerAccountId() {
        return payerAccountId;
    }

    public String getReceiverAccountId() {
        return receiverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(
            PaymentStatus status
    ) {
        this.status = status;
    }

    public static class Builder {

        private final Payment payment;

        public Builder() {
            payment = new Payment();
        }

        public Builder payerAccountId(
                String payerAccountId
        ) {
            payment.payerAccountId =
                    payerAccountId;
            return this;
        }

        public Builder receiverAccountId(
                String receiverAccountId
        ) {
            payment.receiverAccountId =
                    receiverAccountId;
            return this;
        }

        public Builder amount(
                BigDecimal amount
        ) {
            payment.amount = amount;
            return this;
        }

        public Builder description(
                String description
        ) {
            payment.description =
                    description;
            return this;
        }

        public Builder status(
                PaymentStatus status
        ) {
            payment.status = status;
            return this;
        }

        public Payment build() {
            return payment;
        }
    }
}