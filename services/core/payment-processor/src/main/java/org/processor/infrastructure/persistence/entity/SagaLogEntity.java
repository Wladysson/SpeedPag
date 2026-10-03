package org.processor.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "saga_logs")
public class SagaLogEntity {

    @Id
    private String id;

    @Column(
            name = "payment_id",
            nullable = false
    )
    private String paymentId;

    @Column(
            name = "step_name",
            nullable = false
    )
    private String stepName;

    @Column(
            nullable = false
    )
    private String status;

    @Column(
            name = "created_at",
            nullable = false
    )
    private Instant createdAt;

    public SagaLogEntity() {

        this.id = UUID.randomUUID()
                .toString();

        this.createdAt = Instant.now();
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

    public String getStepName() {
        return stepName;
    }

    public void setStepName(
            String stepName
    ) {
        this.stepName = stepName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}