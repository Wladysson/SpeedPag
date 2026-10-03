package org.processor.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import org.handler.domain.event.PaymentRequestedEvent;
import org.processor.application.service.SagaOrchestrator;

import io.smallrye.common.annotation.Blocking;

@ApplicationScoped
public class PaymentRequestedConsumer {

    @Inject
    SagaOrchestrator sagaOrchestrator;

    @Incoming("payment-requested")
    @Blocking
    public void consume(
            PaymentRequestedEvent event
    ) {

        sagaOrchestrator.process(
                event
        );
    }
}