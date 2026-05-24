package org.handler.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;

import org.handler.domain.model.Payment;
import org.handler.infrastructure.persistence.entity.PaymentEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PaymentRepository
        implements PanacheRepository<PaymentEntity> {

    public void persist(
            Payment payment
    ) {

        PaymentEntity entity =
                toEntity(payment);

        persist(entity);
    }

    private PaymentEntity toEntity(
            Payment payment
    ) {

        PaymentEntity entity =
                new PaymentEntity();

        entity.setId(
                payment.getId()
        );

        entity.setPayerAccountId(
                payment.getPayerAccountId()
        );

        entity.setReceiverAccountId(
                payment.getReceiverAccountId()
        );

        entity.setAmount(
                payment.getAmount()
        );

        entity.setDescription(
                payment.getDescription()
        );

        entity.setStatus(
                payment.getStatus().name()
        );

        return entity;
    }
}