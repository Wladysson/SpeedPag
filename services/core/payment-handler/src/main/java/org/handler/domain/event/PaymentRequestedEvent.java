package org.handler.domain.event;

import java.math.BigDecimal;

public record PaymentRequestedEvent(

        String paymentId,

        String payerAccountId,

        String receiverAccountId,

        BigDecimal amount,

        String description
) {
}