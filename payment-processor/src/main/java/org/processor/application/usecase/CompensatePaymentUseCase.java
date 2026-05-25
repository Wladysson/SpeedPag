package org.processor.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.handler.domain.event.PaymentRejectedEvent;
import org.processor.application.service.SagaOrchestrator;

@ApplicationScoped
public class CompensatePaymentUseCase {

    @Inject
    SagaOrchestrator sagaOrchestrator;

    public void execute(
            PaymentRejectedEvent event
    ) {

        sagaOrchestrator.compensate(
                event
        );
    }
}