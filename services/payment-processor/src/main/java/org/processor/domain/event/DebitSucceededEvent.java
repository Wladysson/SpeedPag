package org.processor.domain.event;

import java.math.BigDecimal;

public record DebitSucceededEvent(

        String paymentId,

        String accountId,

        BigDecimal amount
) {
}