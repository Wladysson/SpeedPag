package org.handler.infrastructure.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import org.handler.domain.event.PaymentRequestedEvent;
import org.handler.domain.model.Payment;
import org.handler.infrastructure.messaging.topic.Topics;

import io.smallrye.reactive.messaging.kafka.Record;

@ApplicationScoped
public class KafkaPaymentProducer {

    @Inject
    @Channel(Topics.PAYMENT_REQUESTED)
    Emitter<Record<String, PaymentRequestedEvent>> emitter;

    @Inject
    KafkaHeadersFactory headersFactory;

    public void publish(
            Payment payment
    ) {

        PaymentRequestedEvent event =
                new PaymentRequestedEvent(
                        payment.getId(),
                        payment.getPayerAccountId(),
                        payment.getReceiverAccountId(),
                        payment.getAmount(),
                        payment.getDescription()
                );

        emitter.send(
                Record.of(
                        payment.getId(),
                        event
                )
        );
    }
}