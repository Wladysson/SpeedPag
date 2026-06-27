package org.processor.domain.event;

public record PaymentFailedEvent(

        String paymentId,

        String reason
) {
}