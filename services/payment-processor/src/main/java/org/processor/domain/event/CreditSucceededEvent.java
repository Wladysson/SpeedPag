package org.processor.domain.event;

import java.math.BigDecimal;

public record CreditSucceededEvent(

        String paymentId,

        String accountId,

        BigDecimal amount
) {
}