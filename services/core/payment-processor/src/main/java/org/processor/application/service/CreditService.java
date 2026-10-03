package org.processor.application.service;

import jakarta.enterprise.context.ApplicationScoped;

import org.handler.domain.event.PaymentRequestedEvent;

@ApplicationScoped
public class CreditService {

    public void credit(
            PaymentRequestedEvent event
    ) {
        // credito futuro
    }
}