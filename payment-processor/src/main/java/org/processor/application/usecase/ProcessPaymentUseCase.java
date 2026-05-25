package org.processor.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.handler.domain.event.PaymentRequestedEvent;
import org.processor.application.service.SagaOrchestrator;

@ApplicationScoped
public class ProcessPaymentUseCase {

    @Inject
    SagaOrchestrator sagaOrchestrator;

    public void execute(
            PaymentRequestedEvent event
    ) {

        sagaOrchestrator.process(
                event
        );
    }
}