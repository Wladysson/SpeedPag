package org.processor.infrastructure.messaging;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import org.processor.domain.event.CreditSucceededEvent;
import org.processor.domain.event.DebitSucceededEvent;
import org.processor.domain.event.PaymentCompletedEvent;
import org.processor.domain.event.PaymentFailedEvent;

import io.smallrye.reactive.messaging.kafka.Record;

@ApplicationScoped
public class KafkaEventPublisher {

    @Inject
    @Channel("payment-completed")
    Emitter<Record<String, PaymentCompletedEvent>>
            paymentCompletedEmitter;

    @Inject
    @Channel("payment-failed")
    Emitter<Record<String, PaymentFailedEvent>>
            paymentFailedEmitter;

    @Inject
    @Channel("debit-succeeded")
    Emitter<Record<String, DebitSucceededEvent>>
            debitSucceededEmitter;

    @Inject
    @Channel("credit-succeeded")
    Emitter<Record<String, CreditSucceededEvent>>
            creditSucceededEmitter;

    public void publishDebitSucceeded(
            DebitSucceededEvent event
    ) {

        debitSucceededEmitter.send(
                Record.of(
                        event.paymentId(),
                        event
                )
        );
    }

    public void publishCreditSucceeded(
            CreditSucceededEvent event
    ) {

        creditSucceededEmitter.send(
                Record.of(
                        event.paymentId(),
                        event
                )
        );
    }

    public void publishCompleted(
            PaymentCompletedEvent event
    ) {

        paymentCompletedEmitter.send(
                Record.of(
                        event.paymentId(),
                        event
                )
        );
    }

    public void publishFailed(
            PaymentFailedEvent event
    ) {

        paymentFailedEmitter.send(
                Record.of(
                        event.paymentId(),
                        event
                )
        );
    }
}