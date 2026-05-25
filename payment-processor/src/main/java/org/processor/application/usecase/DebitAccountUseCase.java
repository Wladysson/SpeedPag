package org.processor.application.usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.handler.domain.event.PaymentRequestedEvent;
import org.processor.application.service.DebitService;

@ApplicationScoped
public class DebitAccountUseCase {

    @Inject
    DebitService debitService;

    public void execute(
            PaymentRequestedEvent event
    ) {

        debitService.debit(
                event
        );
    }
}