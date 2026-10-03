package org.processor.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import org.handler.domain.event.PaymentRejectedEvent;
import org.processor.application.service.SagaOrchestrator;

import io.smallrye.common.annotation.Blocking;

@ApplicationScoped
public class PaymentCompensationConsumer {

    @Inject
    SagaOrchestrator sagaOrchestrator;

    @Incoming("payment-compensation")
    @Blocking
    public void consume(
            PaymentRejectedEvent event
    ) {

        sagaOrchestrator.compensate(
                event
        );
    }
}