package org.processor.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.handler.domain.event.PaymentRejectedEvent;
import org.handler.domain.event.PaymentRequestedEvent;

import org.jboss.logging.Logger;

@ApplicationScoped
public class SagaOrchestrator {

    private static final Logger LOG =
            Logger.getLogger(
                    SagaOrchestrator.class
            );

    @Inject
    DebitService debitService;

    @Inject
    CreditService creditService;

    public void process(
            PaymentRequestedEvent event
    ) {

        LOG.infof(
                "Iniciando saga %s",
                event.paymentId()
        );

        debitService.debit(event);

        creditService.credit(event);

        LOG.infof(
                "Saga concluida %s",
                event.paymentId()
        );
    }

    public void compensate(
            PaymentRejectedEvent event
    ) {

        LOG.warnf(
                "Compensando pagamento %s",
                event.paymentId()
        );
    }
}