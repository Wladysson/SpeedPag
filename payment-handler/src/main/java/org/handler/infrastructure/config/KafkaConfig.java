package org.handler.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class KafkaConfig {

    @ConfigProperty(
            name = "kafka.bootstrap.servers"
    )
    String bootstrapServers;

    @ConfigProperty(
            name = "mp.messaging.outgoing.payment.requested.topic"
    )
    String paymentRequestedTopic;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getPaymentRequestedTopic() {
        return paymentRequestedTopic;
    }
}