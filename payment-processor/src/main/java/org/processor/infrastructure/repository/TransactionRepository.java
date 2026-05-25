package org.processor.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import org.processor.infrastructure.persistence.entity.TransactionEntity;

import java.util.Optional;

@ApplicationScoped
public class TransactionRepository
        implements PanacheRepository<TransactionEntity> {

    public Optional<TransactionEntity>
    findByPaymentId(
            String paymentId
    ) {

        return find(
                "paymentId",
                paymentId
        ).firstResultOptional();
    }

    public void save(
            TransactionEntity transaction
    ) {

        persist(transaction);
    }
}