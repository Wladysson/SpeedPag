package org.processor.domain.event;

public record PaymentCompletedEvent(

        String paymentId,

        String status
) {
}