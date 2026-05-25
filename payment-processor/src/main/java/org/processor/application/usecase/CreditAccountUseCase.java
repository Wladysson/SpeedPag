package org.processor.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.handler.domain.event.PaymentRequestedEvent;
import org.processor.application.service.CreditService;

@ApplicationScoped
public class CreditAccountUseCase {

    @Inject
    CreditService creditService;

    public void execute(
            PaymentRequestedEvent event
    ) {

        creditService.credit(
                event
        );
    }
}