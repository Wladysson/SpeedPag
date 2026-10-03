package org.processor.consumer;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import org.jboss.logging.Logger;

@ApplicationScoped
public class DeadLetterConsumer {

    private static final Logger LOG =
            Logger.getLogger(
                    DeadLetterConsumer.class
            );

    @Incoming("payment-dlq")
    public void consume(
            String message
    ) {

        LOG.errorf(
                "Mensagem recebida na DLQ: %s",
                message
        );
    }
}