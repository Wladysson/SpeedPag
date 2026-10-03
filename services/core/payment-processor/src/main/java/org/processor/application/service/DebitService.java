package org.processor.application.service;

import jakarta.enterprise.context.ApplicationScoped;

import org.handler.domain.event.PaymentRequestedEvent;

import java.math.BigDecimal;

@ApplicationScoped
public class DebitService {

    public void debit(
            PaymentRequestedEvent event
    ) {

        if (event.amount()
                .compareTo(
                        BigDecimal.ZERO
                ) <= 0) {

            throw new IllegalArgumentException(
                    "Valor invalido para debito"
            );
        }
    }
}