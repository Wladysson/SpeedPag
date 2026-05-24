package org.handler.domain.event;

public record PaymentRejectedEvent(

        String paymentId,

        String reason
) {
}