package org.processor.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import org.processor.infrastructure.persistence.entity.SagaLogEntity;

import java.util.List;

@ApplicationScoped
public class SagaLogRepository
        implements PanacheRepository<SagaLogEntity> {

    public List<SagaLogEntity>
    findByPaymentId(
            String paymentId
    ) {

        return list(
                "paymentId",
                paymentId
        );
    }

    public void save(
            SagaLogEntity sagaLog
    ) {

        persist(sagaLog);
    }
}